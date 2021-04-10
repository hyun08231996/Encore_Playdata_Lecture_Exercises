package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{
	public Database(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER);
		System.out.println("드라이버 로딩 성공...");
	}
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}
	
	//ssn이 있는지 없는지 확인하는 기능...하나추가...isIsbn()과 동일한 기능
	public boolean isExist(String ssn, Connection conn) throws SQLException{
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) {
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				System.out.println(ps.executeUpdate()+" customer added...");
			}
			else {
				throw new DuplicateSSNException();
			}
		}finally {
			closeAll(ps,conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		//외래키 지정을 제약조건에 추가..customer 테이블에서 삭제를 하게되면 연결된 ssn이 shares 테이블에서도 자동 삭제될 것이다
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate()+" customer deleted...deleteCustomer()...");
			}
			else {
				throw new RecordNotFoundException();
			}
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());
			
			int row = ps.executeUpdate();
			if(row==0) throw new RecordNotFoundException();
			else System.out.println(row+" customer updated...");
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {//특정한 고객이 보유하고 있는 주식보유량을 긁어오는 기능
		Vector<SharesRec> vector = new Vector<SharesRec>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			while(rs.next()) {
				vector.add(new SharesRec(ssn, rs.getString("symbol"), rs.getInt("quantity")));
			}
		}finally {
			closeAll(rs, ps,conn);
		}
		
		return vector;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		CustomerRec cr = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			if(rs.next()) {//ssn에 해당하는 고객이 있다면
				cr = new CustomerRec(ssn, rs.getString("cust_name"), 
										rs.getString("address"));
			}
			cr.setPortfolio(getPortfolio(ssn));
		}finally {
			closeAll(ps,conn);
		}
		return cr;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), 
						rs.getString("address"), getPortfolio(rs.getString("ssn"))));
			}
		}finally {
			closeAll(rs, ps,conn);
		}
		return list;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		ArrayList<StockRec> list = new ArrayList<StockRec>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT symbol, price FROM stock";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StockRec(rs.getString(1), rs.getFloat(2)));
			}
		}finally {
			closeAll(rs, ps,conn);
		}
		return list;
	}
/*
 * 누가 어떤 주식을 몇개 살지를 정의하는 기능...
 * 
 * 지금 가지고 있는 주식의 갯수(quantity)부터 확인해봐야 한다.
 * 
 * 내가 현재 주식을 안가지고 있다 0,100 --> insert into 100
 * 내가 현재 어느정도의 주식을 가지고 있다 50, 100 --> update 150
 */
	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				int q = rs.getInt(1); //q는 현재 가지고 있는 주식의 수량
				int newQuantity = q+quantity; // q(50) + quantity(100)
				
				//update
				String query1 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query1);
				ps.setInt(1, newQuantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
				
				System.out.println(ps.executeUpdate()+" row buyShares()....UPDATE OK");
			}else {//주식이 없는 경우
				//insert
				String query2 = "INSERT INTO shares (ssn, symbol, quantity) VALUES(?,?,?)";
				ps = conn.prepareStatement(query2);
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				ps.setInt(3, quantity);
				
				System.out.println(ps.executeUpdate()+" row buyShares()....INSERT OK");
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
	}
/*
 * 누가 어떤 주식을 몇개 팔것인가에 대한 기능을 정의...
 * 현재 가지고 있는 주식의 수량을 먼저 알아야 한다...int q
 * 4가지 경우 발생
 * 1) 100개를 가지고 있다 ---- 50 SELL ---- update
 * 2) 100개를 가지고 있다 ---- 100 SELL ---- delete
 * 3) 100개를 가지고 있다 ---- 200 SELL ---- InvalidTransactionException
 * 4) 팔려는 주식이 없다 ---- RecordNotFoundException
 */
	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int q = rs.getInt(1);
				int newQuantity = q-quantity;
				if(q < quantity) throw new InvalidTransactionException();
				else if(q == quantity) {
					String query2 = "DELETE FROM shares WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query2);
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					
					System.out.println(ps.executeUpdate()+" row sellShares()...DELETE OK");
				}
				else if(q > quantity) {
					String query3 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query3);
					ps.setInt(1, newQuantity);
					ps.setString(2, ssn);
					ps.setString(3, symbol);
					
					System.out.println(ps.executeUpdate()+" row sellShares()...UPDATE OK");
				}
			} else {
				throw new RecordNotFoundException();
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
	}

}
