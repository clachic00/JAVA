package com.ci.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import com.ci.op.member.model.Member;

@Repository
public class MybatisMemberDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private String mapperPath = "com.ci.op.mybatis.mapper.MemberMapper";
	
	
	
	public int insertMember( Member member) throws SQLException{
	
		return sessionTemplate.update(mapperPath+".insertMember",member);
		
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
