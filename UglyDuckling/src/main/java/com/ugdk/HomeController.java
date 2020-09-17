package com.ugdk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ugdk.board.domain.BoardDTO;
import com.ugdk.board.service.BoardService;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.service.LectureService;
import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	@Autowired
	LectureService lectureService;
	@Autowired
	BoardService boardService;
	
	@GetMapping(value="/")
	public String redirectToHome(Model model) {
		String result;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal.getClass().equals(MemberDTO.class)) {
			result="/home/main";
			//메인 페이지 띄우기 위한 처리
			String id = SecurityContextHolder.getContext().getAuthentication().getName();
			MemberDTO memberInfo = memberService.getMemberInfo(SecurityContextHolder.getContext().getAuthentication().getName());
			LectureDTO lectureInfo = lectureService.getLectureInfo(1);
			List<BoardDTO> boardInfo = boardService.getBoardList(new BoardDTO());
			model.addAttribute("member",memberInfo);
			model.addAttribute("lecture",lectureInfo);
			model.addAttribute("board1",boardInfo.get(0));
			model.addAttribute("board2",boardInfo.get(1));
		}
		else { //anonymousUser
			result="redirect:/member/login.do";
		}
		return result;	
	}
	
	@GetMapping(value="/service.do")
	public String serviceCenter() {
		return "/home/service-center";
	}
}
