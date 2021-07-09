package com.one.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.two.service.CongratulationMailSender;
import com.one.two.service.EmailConfirm;
import com.one.two.service.MemberService;
import com.one.two.service.SendSMSTwilio;
import com.one.two.vo.MemberVO;

@Controller
@RequestMapping(value="/member", method=RequestMethod.GET)
public class MemberController {
	
	@Autowired
	private EmailConfirm email;
	
	@Autowired
	private SendSMSTwilio sms;
	
	@Autowired
	private CongratulationMailSender sender;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberVO member;
	
	@RequestMapping(value = "/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "/member/joinForm";
	}
	
	@RequestMapping(value="/joinFail", method=RequestMethod.GET)
	public String joinFail() {
		return "/member/joinFail";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO member) {
		String page = service.memberJoin(member);
		return page;
	}
	
	@RequestMapping(value="codeCheck", method=RequestMethod.GET)
	public String codeCheck(String memberEmail) {
		
		String page = "";
		if(member.getPhoneCode() == sms.random2()) {
			
			page = "/member/countryCheck";
		} else {
			page = "/member/codeCheck";
		}
		
		return page;
	}
	
	@RequestMapping(value="codeCheck2", method=RequestMethod.GET)
	public String codeCheck2(String memberEmail) {
		
		email.connectEmail(memberEmail);
		System.out.println(email.random2());
		
		
		return "/member/codeCheck2";
	}
	
	@RequestMapping(value="codeCheck3", method=RequestMethod.GET)
	public String codeCheck3(String code) {
		String page = null;
		if(code.equals(email.random2())) {
			page = "/member/joinForm";
		} else {
			page = "redirect:/";
		}
			
		return page;
	}

	@RequestMapping(value="countryCheck", method=RequestMethod.GET)
	public String countryCheck() {
		return "/member/countryCheck";
	}
	
	@RequestMapping(value="countryCheck2", method=RequestMethod.GET)
	public String countryCheck2() {
		sms.sendSMS("member.getPhoneCountry()", "member.getPhoneNumber()");
		System.out.println(sms.random2());
		return "/member/countryCheck2";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String memberLogin(MemberVO member) {
		String page = service.memberLogin(member);
		
		return page;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String memberLogout() {
		service.memberLogout();
		return "redirect:/";
	}
	
	
	
}
