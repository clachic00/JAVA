package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {
	
	public static void main(String[] args) 
		//	throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		//1.DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		System.out.println("Oracle 드라이버 로드 성공");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		//2. 데이터베이스에 접속
		
		conn = DriverManager.getConnection(url,user,pw);
		System.out.println("데이터베이스에 접속했습니다.");

		//트랜젝션 설정
		conn.setAutoCommit(false);
		
		//3. sql 로 데이터처리
		
//		Statement stmt = conn.createStatement();
//		
//		String sql = "insert into test values(?,?)"; 
//		String username = null;
//		String email = null;
//		stmt.executeUpdate("insert into test values ('"+username+"','"+email+"')");
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "SCOTT"); 
//		pstmt.setString(2, "scott@test.com"); 
//		pstmt.executeUpdate();
		
		
		
		//commit : 처리 완료
		conn.commit();
		//4. 데이터베이스 종료
			conn.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
		}
		
		
		}


