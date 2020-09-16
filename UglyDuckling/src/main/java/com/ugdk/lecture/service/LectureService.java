package com.ugdk.lecture.service;

import java.util.List;

import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;

public interface LectureService {

	public LectureDTO getLectureInfo(int idx);
	
	public List<LectureDTO> getAllLectureInfos();
	
	public boolean submitAssignment(AssignmentDTO assignmentDTO);
}
