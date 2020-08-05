package com.ci.op.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.op.member.dao.MemberDaoInterface;
import com.ci.op.member.model.LoginInfo;
import com.ci.op.member.model.LoginRequest;
import com.ci.op.member.model.Member;
import com.ci.op.util.CookieBox;

@Service
public class MemberLoginService {

	/*
	 * @Autowired MemberDao dao;
	 */
	 //인터페이스가 아닌 구현체를 주입해야하니까 세션템플릿을 주입함
     //JdbcTemplateMemberDao dao;
	MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public String login(
			LoginRequest loginRequest,
			HttpSession session,
			HttpServletResponse response) {
		
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		
		
		String loginResult = "";
		
		Member member=dao.selectByIdPw( loginRequest.getUid(), loginRequest.getUpw());

			System.out.println("LoginService Member : " + member);

		
		if (member != null) {
			
			LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());
		
			session.setAttribute("loginInfo", loginInfo);
			
			String cookieName = "uid";
			String cookiepath = session.getServletContext().getContextPath();
					
			if (loginRequest.getRemember() != null) {
				response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 60 * 60 * 24 * 365));
			} else {
				response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 0));
			}
			

			System.out.println(loginRequest.getRedirecUri());
			// 로그인 이 필요했던 이전 페이지 
			loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + loginRequest.getRedirecUri() + "'" + "</script>";

		} else {
			loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
		} 
		
	
	
		
		
		return loginResult;

	}
	
	
}
