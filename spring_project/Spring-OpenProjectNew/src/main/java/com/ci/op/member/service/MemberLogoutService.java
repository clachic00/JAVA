package com.ci.op.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutService {

	public boolean logout(HttpSession session) {
		
		session.invalidate();
		
		return true;
	}
	
	
}
