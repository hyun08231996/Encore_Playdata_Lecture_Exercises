package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBConnectionReview {
	
	public JDBConnectionReview() {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("Connection to DB successful...");
			
//			String insert = "INSERT INTO myScott (name, age, birthday) VALUES (?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(insert);
//			System.out.println("PreparedStatement constructed...");
//			
//			ps.setString(1, "강호동");
//			ps.setInt(2, 45);
//			ps.setString(3, "1966-3-3");
//			System.out.println(ps.executeUpdate()+" person added to myscott table...");
//			
//			String delete = "DELETE FROM myscott WHERE name=?";
//			PreparedStatement ps1 = conn.prepareStatement(delete);
//			
//			ps1.setString(1, "에릭");
//			System.out.println(ps1.executeUpdate()+" person deleted to myscott table...");
			
			String select = "SELECT * FROM myscott";
			PreparedStatement ps2 = conn.prepareStatement(select);
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+", "+rs.getInt(2)+", "+rs.getString(3));
			}
			
			
		}catch(Exception e) {
			System.out.println("Connection to DB failure...");
		}
	}
	
	public static void main(String[] args) {
		new JDBConnectionReview();

	}
	
	static {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver loading failed...");
		}
		
	}

}
