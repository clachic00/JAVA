package com.ci.op.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ci.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	public MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public String getMemberList(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response
			){
		
		model.addAttribute("listView", listService.getView(request, response));
		
		return "/member/memberList";
	}
	
}
