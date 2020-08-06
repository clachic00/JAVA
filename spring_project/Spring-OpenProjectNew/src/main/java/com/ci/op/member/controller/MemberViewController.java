package com.ci.op.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ci.op.member.service.MemberViewService;

@Controller
public class MemberViewController {
	
	@Inject
	MemberViewService viewService;
	
	
	
	// http://localhost:8080/op/member/view/12
	@RequestMapping("/member/view/{uidx}")
	public String getMemberInfo(
		@PathVariable("uidx") int uidx,
		
		Model model
			) {
		
		
		model.addAttribute("member", viewService.getMemberInfo(uidx));
		
		
		return "member/memberView";
	}
	
	
}
