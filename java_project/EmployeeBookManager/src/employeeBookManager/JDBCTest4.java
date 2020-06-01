package employeeBookManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest4 {

	private static void empInsert() {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("사원번호");
		int empno = sc.nextInt();

		System.out.println("사원이름");
		String ename = sc.nextLine();

		System.out.println("직급");
		String job = sc.nextLine();

		System.out.println("관리자");
		int mgr = sc.nextInt();

		System.out.println("입사일");
		String hiredate = sc.nextLine();

		System.out.println("급여");
		int sal = sc.nextInt();

		System.out.println("수당");
		int comm = sc.nextInt();

		System.out.println("부서번호");
		int deptno = sc.nextInt();

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

			// stmt = conn.createStatement();

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);

			int resultCnt = stmt.executeUpdate(sql);

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("행이 입력되지 않았습니다.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private static void empDelete() {

	}

	private static void showData() {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
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

			// stmt = conn.createStatement();

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String sql = "select * from emp";

			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.print(rs.getInt(8) + "\t");

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
