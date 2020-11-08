package com.ugdk.member.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ugdk.board.constant.Method;
import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.service.MemberService;
import com.ugdk.util.UiUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController extends UiUtils {
	@Autowired
	MemberService memberService;

	@GetMapping(value = "/member/login.do")
	public String showLoginPage(Model model) {
		return "member/login";
	}

	@PostMapping(value = "/member/login.do")
	public String processLogin(Model model) {
		return "member/login";
	}

	@GetMapping(value = "/member/success.do")
	public String showLoginSuccessPage(Model model) {
		return "member/success";
	}

	@GetMapping(value = "/member/denied.do")
	public String showLoginDeniedPage(Model model) {
		return "member/denied";
	}

	@GetMapping(value = "/member/signup.do")
	public String showSignupPage(Model model) {
		return "member/signup";
	}

	@PostMapping(value = "/member/signup.do")
	public String processSignup(MemberDTO memberDTO) {
		memberService.joinMember(memberDTO);
		return "redirect:/member/login.do";
	}

	@GetMapping(value = "/member/logout.do")
	public String logout(@RequestParam(value = "type", defaultValue = "normal") String type, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		UiUtils util = new UiUtils();
		if (type.equals("normal")) {
			new SecurityContextLogoutHandler().logout(request, response,
					SecurityContextHolder.getContext().getAuthentication());
		} else if (type.equals("sessionDestroyed")) {
			
		} 
		else {
		}
		
		return "member/logout";

	}
	

	@GetMapping(value = "/member/mypage.do")
	public String showMyPage(Principal principal, Model model) {
		MemberDTO member = memberService.getMemberInfo(principal.getName());
		model.addAttribute("member", member);
		return "member/mypage";
	}

	@PostMapping(value = "/member/mypage.do")
	public String updateMemberInfo(@ModelAttribute("member") MemberDTO memberDto,
			@RequestParam("newPassword") String newPassword, Model model) {
		if (newPassword != "") {
			String originalPassword = memberService.getMemberInfo(memberDto.getId()).getPassword();
			String inputPassword = memberDto.getPassword();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (passwordEncoder.matches(inputPassword, originalPassword)) {
				memberService.updateMemberWithPassword(memberDto, newPassword);
			} else {
				UiUtils util2 = new UiUtils();
				return util2.showMessageWithRedirect("비밀번호가 틀렸습니다", "/member/mypage.do", Method.GET, null, model);
			}
		} else {
			memberService.updateMember(memberDto);
		}
		return "member/mypage";
	}

	@GetMapping(value = "/member/autologout.do")
	public String autoLogout(Model model) {
		UiUtils util = new UiUtils();
		return util.showMessageWithRedirect("로그인 만료 시간이 되어 로그아웃 되었습니다.", "/", Method.GET, null, model);
	}
}
