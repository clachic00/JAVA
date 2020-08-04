package com.ci.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ci.op.member.model.Member;

@Repository
public class MemberDao {

	
	
	public int insertMember(Connection conn, Member member) throws SQLException{
		
		int resultCnt =0;
		
		PreparedStatement pstmt = null;
		
		System.out.println("1"+member);

		String sql = "insert into finalproject.member (uid, upw, uname, uphone, uphoto) values(?,?,?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphone());
			pstmt.setString(5, member.getUphoto());

			resultCnt = pstmt.executeUpdate();
			

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return resultCnt;
		
	}
	
	
	public Member selectByIdPw(Connection conn, String uid, String upw) throws SQLException {
	
		PreparedStatement pstmt = null;
		ResultSet rs;
		Member member = null;
		
		
		
		try {
			String sql = "select * from finalproject.member where uid=? and upw = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setUidx(rs.getInt("uidx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphone(rs.getString("uphone"));
				member.setUphoto(rs.getString("uphoto"));

			}
		
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		
		
		return member;
		
	}
	
	
	
	
	
	
	
	
	
}
