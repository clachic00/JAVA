package com.ci.op.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ci.op.member.service.MemberLogoutService;

@Controller
public class LogoutController {

	@Autowired
	MemberLogoutService logoutService;
	
	
	@RequestMapping("/login/logout")
	public String logout(
			HttpSession session
			) {
		
		logoutService.logout(session);
		
		String viewName = "redirect:/index";
		
		
		return viewName;
	}
	
	
	
	
	
}
