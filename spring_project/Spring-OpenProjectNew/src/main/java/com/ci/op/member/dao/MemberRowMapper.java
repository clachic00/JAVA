package com.ci.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ci.op.member.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

		Member member= new Member();
		member.setUidx(rs.getInt("uidx"));
		member.setUid(rs.getString("uid"));
		member.setUpw(rs.getString("upw"));
		member.setUname(rs.getString("uname"));
		member.setUphoto(rs.getString("uphoto"));
		member.setUphone(rs.getString("uphone"));

		return member;
	}

	
}
