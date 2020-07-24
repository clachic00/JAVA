package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Comments;
import member.model.Member;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member (memail, mpw, mname, mphoto, mphonenum ) VALUES (?,?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemail());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMphoto());
			pstmt.setString(5, member.getMphonenum());

			resultCnt = pstmt.executeUpdate();

		} finally {

			if (pstmt != null) {
				pstmt.close();

			}

		}

		return resultCnt;

	}

	public int selectByEmail(Connection conn, String email) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			String sql = "select count(*) from member where memail=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select count(*) from member");

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return resultCnt;
	}

	public List<Member> selectList(Connection conn, int startRow, int count) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Member> memberList = new ArrayList<Member>();

		String sql = "select * from project.member order by mname limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member();
				member.setMidx(rs.getInt("midx"));
				member.setMemail(rs.getString("memail"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMphoto(rs.getString("mphoto"));
				member.setMphonenum(rs.getString("mphonenum"));

				memberList.add(member);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return memberList;
	}

	public int editMember(Connection conn, Member member) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "update member set " + " mpw=?, mname=?, mphonenum=?, mphoto=? " + " where midx=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMpw());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMphonenum());
			pstmt.setString(4, member.getMphoto());
			pstmt.setInt(5, member.getMidx());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	public Member selectByIdx(Connection conn, int idx) throws SQLException {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			String sql = "select * from member where midx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMidx(rs.getInt("midx"));
				member.setMemail(rs.getString("memail"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMphoto(rs.getString("mphoto"));
				member.setMphonenum(rs.getString("mphonenum"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return member;
	}
	public int memberDelete(Connection conn, int midx) throws SQLException {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = "delete from member where midx=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, midx);
				
				result = pstmt.executeUpdate();
				
			} finally {
				if(pstmt != null) {
					pstmt.close();
				}
			}
			
			return result;
		}
	
	public int userCheck(String memail, String mpw, Connection conn) {

		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs;

		try {

			String sql = "select mpw from member where memail=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("mpw").equals(mpw)) {
					result = 1; // 로그인됨
				} else {
					result = 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public Member userInfo(String uid, Connection conn) {
		Member member=null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		
		try {
					
			String sql = "select * from member where memail=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMidx(rs.getInt("midx"));
				member.setMemail(rs.getString("memail"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMphoto(rs.getString("mphoto"));
				member.setMphonenum(rs.getString("mphonenum"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		return member;
	}
	
	
	
	
	

	public int writeComment(Connection conn, Comments comments) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.comments (bidx, memail, comment) VALUES (?, ?, ?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comments.getBidx());
			pstmt.setString(2, comments.getMemail());
			pstmt.setString(3, comments.getComment());
			
			resultCnt = pstmt.executeUpdate();


			
		} finally {

			if (pstmt != null) {
				pstmt.close();

			}

		}

		return resultCnt;

	}
	
	
	
	
	public List<Comments> commentList(Connection conn, String memail) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Comments> commentList = new ArrayList<Comments>();

		String sql = "select * from project.comments where memail =?";

		try {
			pstmt = conn.prepareStatement(sql);
	

			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				Comments comments = new Comments();
				comments.setCidx(rs.getInt("cidx"));
				comments.setBidx(rs.getInt("bidx"));
				comments.setMemail(rs.getString("memail"));
				comments.setComment(rs.getString("Comment"));
			

				commentList.add(comments);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return commentList;
	}
	
	
	
	
	
	
	
	
	

}
