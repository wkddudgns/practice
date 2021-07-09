package com.one.two.service;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.one.two.dao.MemberDAO;
import com.one.two.dao.MemberMapper;

import org.springframework.stereotype.Service;

import com.one.two.vo.MemberVO;
import com.sun.mail.util.logging.MailHandler;

@Service
public class MemberService {

	@Inject
	private MemberDAO dao;
	
	@Autowired
	private CongratulationMailSender mail;
	
	@Autowired
	private EmailConfirm email;
	
	@Autowired
	private HttpSession session;
	
	
	public String memberJoin(MemberVO member) {
		int cnt = dao.memberJoin(member);
		String page = "";
		if(cnt==0) {
			page = "redirect:/member/joinFail";
		}else {
	
			page = "redirect:/";
		}
		return page;
	}
	
	public MemberVO memberSelectOne(String member_id) {
		MemberVO member = dao.selectOne(member_id);
		
		return member;
	}
	
	public String memberLogin(MemberVO member) {
		MemberVO loginCheck = dao.selectOne(member.getEmail());
		String page = "";
		if(loginCheck != null && loginCheck.getPassword().equals(member.getPassword())) {
			
			session.setAttribute("loginId", member.getEmail());
			page = "redirect:/";
		} else {
			page = "redirect:/member/loginForm";
		}
		return page;
	}
	
	public void memberLogout() {
		session.removeAttribute("loginId");
	}


}	


