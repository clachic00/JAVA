package PhoneBookVer7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDao {

	public List<PhoneBook> pbList() {

		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object getter/setter , toString, equals

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<PhoneBook> deptList = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 2. 데이터베이스 연결
			conn = ConnectionProvider.getConnection();

			String sql = "select * from dept  order by dname";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PhoneBook pb = new PhoneBook(rs.getInt("pidx"), rs.getString("pbname"), rs.getString("pbnumber"),
						rs.getString("pbaddr"), rs.getString("pbemail"), rs.getString("pbmajor"), rs.getInt("pbyear"),
						rs.getString("pbcompany"), rs.getString("pbjob"), rs.getString("pbcafename"),
						rs.getString("pbnickname")

				);

				deptList.add(pb);

			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}

		}
		return deptList;

	}

	public int pbInsert(PhoneBook pb) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into dept  (pidx,pbname,pbnumber,pbaddr,pbemail,pbmajor,pbyear,pbcompany,pbjob,pbcafename,pbnickname)  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pb.getPidx());
			pstmt.setString(2, pb.getPbname());
			pstmt.setString(3, pb.getPbnumber());
			pstmt.setString(4, pb.getPbaddr());
			pstmt.setString(5, pb.getPbemail());
			pstmt.setString(6, pb.getPbmajor());
			pstmt.setInt(7, pb.getPbyear());
			pstmt.setString(8, pb.getPbcompany());
			pstmt.setString(9, pb.getPbjob());
			pstmt.setString(10, pb.getPbcafename());
			pstmt.setString(11, pb.getPbnickname());

			resultCnt = pstmt.executeUpdate();

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
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

		}

		return resultCnt;

	}

	public int pbEdit(PhoneBook pb, Connection conn) {

		// JDBC 사용 객체
		// Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {
			// Connection 객체 생성
			// conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.

			String sql = "update contact  set  pbname=?, pbnumber=?, pbaddr=?,pbemail=?,pbmajor=?,pbyear=?,pbcompany=?,pbjob=?,pbcafename=?,pbnickname=? "
					+ " where pidx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pb.getPidx());
			pstmt.setString(2, pb.getPbname());
			pstmt.setString(3, pb.getPbnumber());
			pstmt.setString(4, pb.getPbaddr());
			pstmt.setString(5, pb.getPbemail());
			pstmt.setString(6, pb.getPbmajor());
			pstmt.setInt(7, pb.getPbyear());
			pstmt.setString(8, pb.getPbcompany());
			pstmt.setString(9, pb.getPbjob());
			pstmt.setString(10, pb.getPbcafename());
			pstmt.setString(11, pb.getPbnickname());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}

		}

		return resultCnt;

	}

	public int pbDelete(String pbname) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			String sql = "delete from contact  where pbname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, pbname);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
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

		}

		return resultCnt;

	}

	public List<PhoneBook> pbSearch(String pbname) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<PhoneBook> list = new ArrayList<PhoneBook>();

		try {

			// 2. 데이터베이스 연결
			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// Mysql
			// "SELECT * FROM dept WHERE dname LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from dept where dname like '%'||?||'%'

			String sql = "select * from contact  where pbname like '%'||?||'%' or  loc like '%'||?||'%'";
			// String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, pbname);
			pstmt.setString(2, pbname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new PhoneBook(rs.getInt("pidx"), rs.getString("pbname"), rs.getString("pbnumber"),
						rs.getString("pbaddr"), rs.getString("pbemail"), rs.getString("pbmajor"), rs.getInt("pbyear"),
						rs.getString("pbcompany"), rs.getString("pbjob"), rs.getString("pbcafename"),
						rs.getString("pbnickname")));
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
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

		}

		return list;

	}

	
	public int pbSearchCount(String searchName, Connection conn) {
		
		//Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int rowCnt = 0;
		
		try {
			//conn = ConnectionProvider.getConnection();
			
			String sql = "select count(*) from contact where pbname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rowCnt = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rowCnt;
	}
	
	
	public PhoneBook pbSearchName(String searchName, Connection conn) {
		
		
		PhoneBook pb = null;
		
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//conn = ConnectionProvider.getConnection();
			
			String sql = "select * from dept where dname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pb = new PhoneBook(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return pb;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
