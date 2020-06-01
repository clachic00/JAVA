package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest4 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 1. DB 드라이버 로드

			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("데이터베이스에 접속했습니다.");

			// 3. Statement

			stmt = conn.createStatement();

			
			pstmt.setInt(1, 10);
			rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String sql = "insert into dept (deptno, dname, loc) " + " values (60, 'design', 'jeju')"
						+" values (?, ?, ?)";
						
			pstmt.setInt(1, 70);
			pstmt.setString(2, "마케팅");
			pstmt.setString(3, "서울");
			
			int resultCnt = stmt.executeUpdate(sql);

			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt+"행이 입력되었습니다.");
			}else {
				System.out.println("행이 입력되지 않았습니다.");
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			 
				 e.printStackTrace();
			 
			}
			 finally {
				 // 4. close
					if(rs!=null) {
						try {
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					if(conn!=null) {
						
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
									
				}
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
					}
		}
	}
				
				
