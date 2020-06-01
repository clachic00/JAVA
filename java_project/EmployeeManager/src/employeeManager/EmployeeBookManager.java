package employeeManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeBookManager {

	static private EmployeeBookManager ebm = new EmployeeBookManager();

	static EmployeeBookManager getInstance() {

		return ebm;
	}

	EmployeeBookManager() {

	}

	Scanner sc = new Scanner(System.in);

	public void empInsert() {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("사원번호");
		int empno = sc.nextInt();
		sc.nextLine();
		System.out.println("사원이름");
		String ename = sc.nextLine();

		System.out.println("직급");
		String job = sc.nextLine();

		System.out.println("관리자");
		int mgr = sc.nextInt();
		sc.nextLine();

		System.out.println("입사일");
		String hiredate = sc.nextLine();

		System.out.println("급여");
		int sal = sc.nextInt();
		sc.nextLine();

		System.out.println("수당");
		int comm = sc.nextInt();
		sc.nextLine();

		System.out.println("부서번호");
		int deptno = sc.nextInt();
		sc.nextLine();

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
			System.out.println("==========================================");

			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("행이 입력되지 않았습니다.");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {

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

	public void empList() {

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

			stmt = conn.createStatement();

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String sql = "select * from emp order by ename";

			System.out.println("sql :" + sql);

			rs = stmt.executeQuery(sql);

			int resultCnt = 0;

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.print(rs.getInt(8) + "\n");
				resultCnt++;

			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {

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

	public void empDelete() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("삭제할 사원이름을 입력해주세요 ");

		String searchName = sc.nextLine();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();

			String sql = "delete from emp  where ename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			int resultCnt = pstmt.executeUpdate();

			if (resultCnt < 1) {
				System.out.println("삭제할 정보가 검색 결과가 없습니다.");
			} else {
				System.out.println(resultCnt + "행이 삭제 되었습니다.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {

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

	public void empSearch() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("검색할 사원이름을 입력해주세요 ");

		String searchName = sc.nextLine();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();

			String sql = "select * from emp  where ename like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();

			int resultCnt = 0;

			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate").substring(0, 10) + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				resultCnt++;
			}

			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {

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

	public void empEdit() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("수정할 사원이름을 입력해주세요 ");

		String searchName = sc.nextLine();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String selectSql = "select from emp where ename='" + searchName + "'";

			System.out.println("사원번호 : ");
			int empno = sc.nextInt();
			System.out.println("사원이름 : ");
			sc.nextLine();
			String ename = sc.nextLine();
			System.out.println("직급(업무) : ");
			String job = sc.nextLine();
			System.out.println("관리자 : ");
			int mgr = sc.nextInt();
			System.out.println("입사일 : ");
			sc.nextLine();
			String hiredate = sc.nextLine();
			System.out.println("급여 : ");
			int sal = sc.nextInt();
			System.out.println("수당 : ");
			int comm = sc.nextInt();
			System.out.println("부서번호 : ");
			int deptno = sc.nextInt();

			String sql = "insert into emp " + " (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {

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

	public void deptInsert() {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("부서번호");
		int deptno = sc.nextInt();
		sc.nextLine();

		System.out.println("부서명");
		String dname = sc.nextLine();

		System.out.println("지역");
		String loc = sc.nextLine();

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
			System.out.println("==========================================");

			String sql = "insert into emp (deptno, dname, loc) " + " values (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("행이 입력되지 않았습니다.");
			}

		} catch (ClassNotFoundException e) {
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

	public void deptList() {

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

			stmt = conn.createStatement();

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("==========================================");

			String sql = "select * from dept order by ename";

			System.out.println("sql :" + sql);

			rs = stmt.executeQuery(sql);

			int resultCnt = 0;

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");

				resultCnt++;

			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
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

	public void deptDelete() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("삭제할 부서번호를 입력해주세요 ");

		int searchNo = sc.nextInt();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();

			String sql = "delete from emp  where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchNo);
			int resultCnt = pstmt.executeUpdate();

			if (resultCnt < 1) {
				System.out.println("삭제할 정보가 검색 결과가 없습니다.");
			} else {
				System.out.println(resultCnt + "행이 삭제 되었습니다.");
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

	public void deptSearch() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("검색할 부서이름을 입력해주세요 ");

		String searchName = sc.nextLine();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();

			String sql = "select * from emp  where dname like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, searchName);
			rs = pstmt.executeQuery();

			int resultCnt = 0;

			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\t");

				resultCnt++;
			}

			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			// 4. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e1) {
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

	public void deptEdit() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		System.out.println("수정할 부서이름을 입력해주세요 ");

		String searchName = sc.nextLine();

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

			// pstmt.setInt(1, 10);
			// rs=pstmt.executeQuery();

			String selectSql = "select from dept where dname='" + searchName + "'";

			System.out.println("부서번호 : ");
			int deptno = sc.nextInt();
			System.out.println("부서이름 : ");
			sc.nextLine();
			String dname = sc.nextLine();
			System.out.println("지역: ");
			String loc = sc.nextLine();

			String sql = "insert into dept " + " (deptno, dname, loc) " + " values (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
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
