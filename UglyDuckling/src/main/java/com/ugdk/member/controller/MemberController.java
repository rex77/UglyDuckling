package com.ugdk.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.service.MemberService;
import com.ugdk.util.UiUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController extends UiUtils {
	@Autowired
	MemberService memberService;
	
	@GetMapping(value="/member/login.do")
	public String showLoginPage(Model model) {
		return "member/login" ;
	}
	
	@PostMapping(value="/member/login.do")
	public String processLogin(Model model) {
		return "member/login" ;
	}
	
	@GetMapping(value="/member/success.do")
	public String showLoginSuccessPage(Model model) {
		return "member/success" ;
	}
	
	@GetMapping(value="/member/denied.do")
	public String showLoginDeniedPage(Model model) {
		return "member/denied" ;
	}
	
	@GetMapping(value="/member/signup.do")
	public String showSignupPage(Model model) {
		return "member/signup";
	}
	
	@PostMapping(value="/member/signup.do")
	public String processSignup(MemberDTO memberDTO) {
		memberService.joinUser(memberDTO);
		return "redirect:/member/login.do";
	}
	
	@GetMapping(value="/member/logout.do")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    System.out.println("logout.do");
	    return "redirect:/";
	  }
	
	@GetMapping(value="/member/mypage.do")
	public String showMyPage(Model model) {
		return "redirect:/member/login.do";
	}
}
