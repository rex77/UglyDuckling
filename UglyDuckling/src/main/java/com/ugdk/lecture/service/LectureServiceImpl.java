package com.ugdk.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.mapper.LectureMapper;

@Service
public class LectureServiceImpl implements LectureService {
	@Autowired
	private LectureMapper lectureMapper;
	
	public LectureDTO getLectureInfo(int idx) {
		return lectureMapper.getLectureInfo(idx);
	}

	public List<LectureDTO> getAllLectureInfos() {
		return lectureMapper.getAllLectureInfos();
	}

	@Override
	public boolean submitAssignment(AssignmentDTO assignmentDTO) {
		return lectureMapper.submitAssignment(assignmentDTO);
	}
}
