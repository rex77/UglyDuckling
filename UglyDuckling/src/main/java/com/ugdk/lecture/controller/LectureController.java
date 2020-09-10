package com.ugdk.lecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.service.LectureService;

@Controller
public class LectureController {
	@Autowired
	LectureService lectureService;

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
	public String proceedAssignment(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int idx = (int) session.getAttribute("progress");
		System.out.println("idx: " + idx);
		if (idx == 0)
			idx = 1;
		LectureDTO lecture = lectureService.getLectureInfo(idx);
		model.addAttribute("lec",lecture);
		return "lecture/assignment";

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