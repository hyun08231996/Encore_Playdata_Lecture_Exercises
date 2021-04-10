package jdbc.step3.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/*
 * 디비 Access 하기위한 4단계 작업을 작성하는 로직..
 * 1. 디비서버에 대한 파편적인 정보들(서버 실제값)을 상수로 지정
 * -->
 * 문제점
 * 소스코드에 서버정보가 그대로 노출되어져 있다.
 * 메타데이터화 시키자
 * ::
 * 해결책
 * 2. 상수값과 추상메소드를 구성요소로 가지는 인터페이스를 별도의 모듈로 생성하고
 * 	  그 안에 서버 정보를 메타데이터화 시키겠다.
 * --->
 * 
 * 3. 자바 진영에서 가장 많이 사용하는 Meta Data는 
 * 	  properties파일이다.
 * 	  Key - Value값을 모두 스트링으로 저장할수 있다는 특징에 착안되어져
 * 	  서버정보를 저장하는 메타데이터로 가장 많이 사용되어진다.
 * 	  config > db.properties
 */
public class JDBC4StepTest {
	static String driver;
	static String url;
	static String user;
	static String pass;
	static String query;
	
	public JDBC4StepTest() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		System.out.println("1. 드라이버 로딩 성공..");
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("2. 디비 연결 성공..");
		/*
		String query = "INSERT INTO mytable (num, name, address) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);//이때 값이 들어가진 않는다!!
		System.out.println("3. PreparedStatement 생성..");
		
		ps.setInt(1, 333);
		ps.setString(2, "박나래");
		ps.setString(3, "여의도");
		
		//4. Query문 실행 메소드 -> executeUpdate(), executeQuery()
		int row = ps.executeUpdate();
		System.out.println(row+" row insert...ok");
		
		String querydel = "DELETE FROM mytable WHERE num=?";
		PreparedStatement ps1 = conn.prepareStatement(querydel);
		System.out.println("3. PreparedStatement 생성..");
		
		ps1.setInt(1, 333);
		System.out.println(ps1.executeUpdate()+" row delete...ok");
		
		//update문 실행...111인 사람의 이름과 주소를 변경 (정우재, 방배동)
		String queryUpdate = "UPDATE mytable SET name=?, address=? WHERE num=?";
		PreparedStatement ps2 = conn.prepareStatement(queryUpdate);
		System.out.println("3. PreparedStatement 생성..");
		
		ps2.setString(1, "정우재");
		ps2.setString(2, "방배동");
		ps2.setInt(3, 111);
		System.out.println(ps2.executeUpdate()+" row update...ok");
		*/
		
		//mytable에 있는 모든 정보를 다 가져와서 출력
		PreparedStatement ps3 = conn.prepareStatement(query);
		System.out.println("3. PreparedStatement 생성..");
		
		ResultSet rs = ps3.executeQuery();
		System.out.println("================================================");
		while(rs.next()) {
			System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+rs.getString("address"));
		}
		System.out.println("================================================");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new JDBC4StepTest();

	}
	
	static {
		//1. properties파일의 내용을 로드해온다.
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));//절대경로 보다는 상대경로
			
			driver = p.getProperty("jdbc.mysql.driver");
			url = p.getProperty("jdbc.mysql.url");
			user = p.getProperty("jdbc.mysql.user");
			pass = p.getProperty("jdbc.mysql.pass");
			query = p.getProperty("jdbc.sql.selectAll");
			
			
		} catch (Exception e) {
			
		} 
	}

}
