package com.ugdk.lecture.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.domain.ProgressDTO;
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

	@Override
	public List<ProgressDTO> getProgressInfos(String id, int unit) {
		HashMap<String,Object> param = new HashMap();
		param.put("id", id);
		param.put("unit", unit);
		return lectureMapper.getProgressInfos(param);
	}

	@Override
	public boolean updateProgressInfo(ProgressDTO progressDTO) {
		//이미 해당 컨텐츠에 대해 올라간 값이 있는 지 찾기 위해 검색
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("unitId", progressDTO.getUnitId());
		param.put("contentId", progressDTO.getContentId());
		param.put("memberId", progressDTO.getMemberId());
		ProgressDTO originalRecord = lectureMapper.getProgressInfo(param);
		//만약 검색 결과가 없으면
		if(originalRecord == null) {
			//insert
			return lectureMapper.insertProgressInfo(progressDTO);
		} else {
			//update
			originalRecord.setScore(progressDTO.getScore());
			return lectureMapper.updateProgressInfo(originalRecord);
		}
		
	}

	@Override
	public ProgressDTO getProgressInfo(int unitId, int contentId, String memberId) {

		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("unitId", unitId);
		param.put("contentId", contentId);
		param.put("memberId", memberId);
		
		return lectureMapper.getProgressInfo(param);
	}
}
