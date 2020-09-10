package com.ugdk;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ugdk.member.domain.MemberDTO;

@Controller
public class HomeController {
	@GetMapping(value="/")
	public String redirectToHome() {
		String result = "redirect:";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal.getClass().equals(String.class))
			result+="/member/login.do";
		else
			result+="/board/list.do";
		return result;	
	}
}
