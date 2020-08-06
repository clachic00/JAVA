package com.ci.op.member.dao;

import java.util.List;
import java.util.Map;

import com.ci.op.member.model.Member;
import com.ci.op.member.model.MemberXML;

public interface MemberDaoInterface {

		public Member selectByIdPw(String uid, String upw);
		public int insertMember(Member member);
	// 전체 게시물의 개수 : 검색 포함
		public int totalCount(Map search);
		
		// 전체 게시물의  List<Member> 로 반환
		public List<Member> selectList(Map search);
	
		public Member selectByIdx(int uidx);
		
		public List<MemberXML> selectTotalListXml();
	
}