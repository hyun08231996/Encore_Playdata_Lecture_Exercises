package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXCAppTest1 {

	public static void main(String[] args) throws Exception{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩...");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB연결 성공...");
		
		//2개의 쿼리문 작성.
		String query1 = "INSERT INTO test (name, birthday) VALUES (?,?)";
		String query2 = "SELECT num, name, birthday FROM test WHERE num=?";
		
		//위 2개의 작업을 transaction 처리함(더이상 쪼개질 수 없는 원자단위로 묶음)
		//transaction 시작
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.setString(2, "1980-01-22"); //3
		ps.executeUpdate();
		
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 3);//만약에 4를넣으면, num이 4인 사람이 없기 때문에 에러...Rollback...위 부분도 추가되지 않게된다.
		
		ResultSet rs = ps2.executeQuery();
		if(!rs.next()) {//4에 해당하는 사람이 존재하지 않는다면...
			//rollback
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 사람이 없어서 rollback 합니다..");
		}else { //만약에 4에 해당하는 사람이 존재한다면
			//commit
			conn.commit();
			System.out.println("commit 성공...");
		}
		
		//이 안에 들어오는 모든 작업은 원자성을 가진다.
		
		
		//transaction 마무리...다시 원래대로 돌려놓음
		conn.setAutoCommit(true);

	}

}
