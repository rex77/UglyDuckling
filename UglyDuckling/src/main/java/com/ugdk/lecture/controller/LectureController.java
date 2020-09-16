package com.ugdk.lecture.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ugdk.board.constant.Method;
import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.service.LectureService;
import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.service.MemberService;
import com.ugdk.util.UiUtils;

@Controller
public class LectureController extends UiUtils  {
	@Autowired
	LectureService lectureService;
	@Autowired
	MemberService memberService;

	// 강의 뷰(실제)
	@GetMapping(value = "/lecture/view.do")
	public String openLectureDetail(@RequestParam(value = "idx", required = false, defaultValue = "1") int idx,
			Model model) {
		LectureDTO lecture;
		lecture = lectureService.getLectureInfo(idx);
		model.addAttribute("lec", lecture);
		return "lecture/status";

	}

	@GetMapping(value = "/lecture/assignment.do")
	public String openAssignment(HttpServletRequest request, Principal principal, Model model) {
		//로그인 정보 추출
		String user_id = principal.getName();
		MemberDTO member = memberService.getMemberInfo(user_id);
		
		//프로그레스 정보 인덱스 가져오기
		int idx = member.getLast_progress();
		if (idx == 0)
			idx = 1;
		
		//인덱스 바탕으로 강의 정보 가져오기
		LectureDTO lecture = lectureService.getLectureInfo(idx);
		
		//애트리뷰트 추가
		model.addAttribute("lecture",lecture);
		return "lecture/assignment";

	}
	
	@PostMapping(value="/lecture/assignment.do")
	public String submitAssignment(AssignmentDTO assignmentDTO, Model model) {
		boolean result = lectureService.submitAssignment(assignmentDTO);
		if(result == false )
			return showMessageWithRedirect("과제 제출에 실패하였습니다.", "/lecture/assignment.do", Method.GET, null, model);
		else
			return showMessageWithRedirect("과제 제출이 완료되었습니다.", "/lecture/assignment.do", Method.GET, null, model);
		
	}

//	//강의 뷰(프로토타입)
//	@GetMapping(value="/lecture/view.do")
//	public String openLectureDetail(@RequestParam(value = "idx", required = false, defaultValue="1") int idx) {
//		String view = "";
//		view += "lecture/lec";
//		view += idx;
//		return view;
//	}

}