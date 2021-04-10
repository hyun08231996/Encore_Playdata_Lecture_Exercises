package com.encore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.dao.BookDAO;
import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

import config.ServerInfo;

public class BookDAOImpl implements BookDAO {
	private static BookDAOImpl dao = new BookDAOImpl();
	ArrayList<Book> list;
	
	private BookDAOImpl() {
//		Class.forName(ServerInfo.DRIVER);
//		System.out.println("Driver loading...");
		try{
			list = bookList();
		}catch(Exception e) {
			
		}
	}
	
	public static BookDAOImpl getInstance() {
		return dao;
	}
	//공통적인 로직...Connection getConnect()
	//공통적인 로직...closeAll()...오버로딩기법
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}
	
	public boolean isIsbn(String isbn, Connection conn) throws SQLException{ //true, false
		
		String query = "SELECT isbn FROM book WHERE isbn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	private ArrayList<Book> bookList() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnect();
		ArrayList<Book> temp = new ArrayList<Book>();
		
		String query = "SELECT isbn, title, author, publisher, price FROM book";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			temp.add(new Book(rs.getString("isbn"),rs.getString("title"),
					rs.getString("author"),rs.getString("publisher"),
					rs.getInt("price")));
		}
		
		closeAll(rs, ps, conn);
		
		return temp;
	}
	
//	@Override
//	public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		conn = getConnect();
//		boolean flag = false;
//		
//		for(Book b : list) {
//			if(b.getIsbn().equals(vo.getIsbn())) throw new DuplicateISBNException();
//			else flag = true;
//		}
//		
//		if(flag==true) {
//			String query = "INSERT INTO book VALUES (?,?,?,?,?)";
//			ps = conn.prepareStatement(query);
//			
//			ps.setString(1, vo.getIsbn());
//			ps.setString(2, vo.getTitle());
//			ps.setString(3, vo.getWriter());
//			ps.setString(4, vo.getPublisher());
//			ps.setInt(5, vo.getPrice());
//			System.out.println(ps.executeUpdate()+" book added...");
//		}
//		closeAll(ps, conn);
//	}

	public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!isIsbn(vo.getIsbn(), conn)) { //isbn에 해당하는 책이 없다면...
				System.out.println("true...");
				String query = "INSERT INTO book VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getIsbn());
				ps.setString(2, vo.getTitle());
				ps.setString(3, vo.getWriter());
				ps.setString(4, vo.getPublisher());
				ps.setInt(5, vo.getPrice());
				System.out.println(ps.executeUpdate()+" row Register!!!");
			}else {						//isbn에 해당하는 책이 있다면... 예외발생
				throw new DuplicateISBNException();
			}
		}finally {
			closeAll(ps, conn);
		}
	}
	public void deleteBook(String isbn) throws SQLException, BookNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "DELETE FROM book WHERE isbn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, isbn);
			int row = ps.executeUpdate();
			if(row==0) throw new BookNotFoundException();
			else System.out.println(row+" row deleted...");
		}finally {
			closeAll(ps, conn);
		}
	}
//	@Override
//	public void deleteBook(String isbn) throws SQLException, BookNotFoundException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		conn = getConnect();
//		boolean flag = false;
//		
//		for(Book b : list) {
//			if(b.getIsbn().equals(isbn)) flag = true;
//		}
//		
//		if(flag==true) {
//			String query = "DELETE FROM book WHERE isbn=?";
//			ps = conn.prepareStatement(query);
//			
//			ps.setString(1, isbn);
//			
//			System.out.println(ps.executeUpdate()+" book deleted...");
//		}
//		if(flag==false) throw new BookNotFoundException();
//		
//		closeAll(ps, conn);
//		
//	}

	@Override
	public Book findByBook(String isbn, String title) throws SQLException {
		Book book = null;
		
		for(Book b : list) {
			if(b.getIsbn().equals(isbn) && b.getTitle().equals(title)) book = b;
		}
		
		return book;
	}

	@Override
	public ArrayList<Book> findByWriter(String writer) throws SQLException {
		ArrayList<Book> temp = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT * FROM book WHERE author=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, writer);
			rs = ps.executeQuery();
			while(rs.next()) {
				Book vo = new Book(rs.getString(1),rs.getString(2), writer, rs.getString(4),rs.getInt(5));
				temp.add(vo);
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		return temp;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) throws SQLException {
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for(Book b : list) {
			if(b.getPublisher().equals(publisher)) temp.add(b);
		}
		
		return temp;
	}

	public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
		if(min<=0 || min<0 || min>=max) throw new InvalidInputException();
		
		ArrayList<Book> temp = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "SELECT * FROM book WHERE price >= ? AND price <= ?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			while(rs.next()) {
				Book vo = new Book(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				temp.add(vo);
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return temp;
	}
//	@Override
//	public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
//		ArrayList<Book> temp = new ArrayList<Book>();
//		
//		if(min>max) throw new InvalidInputException();
//		
//		for(Book b : list) {
//			if(b.getPrice()>min&&b.getPrice()<max) temp.add(b);
//		}
//		
//		return temp;
//	}
	
	public void discountBook(int per, String publiser) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn= getConnect();
			String query = "UPDATE book SET price = (price * (1-?/100)) WHERE publisher=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, per);
			ps.setString(2, publiser);
			System.out.println(ps.executeUpdate()+" row price updated");
			
		}finally {
			closeAll(ps, conn);
		}
	}

//	@Override
//	public void discountBook(int per, String publiser) throws SQLException {
//		double discountPrice = 0;
//		for(Book b : list) {
//			if(b.getPublisher().equals(publiser)) {
//				discountPrice = (b.getPrice()*(100-per))/100;
//				System.out.println("Discounted price of "+"["+b.getIsbn()+","+b.getTitle()+"]"+" is "+discountPrice);
//			}
//		}
//	}

	@Override
	public void printAllInfo() throws SQLException {
		for(Book b : list) {
			System.out.println(b);
		}
	}

}
