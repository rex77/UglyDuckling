package com.ugdk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value="/")
	public String redirectToHome() {
		return "redirect:/board/list.do";	
	}
}
