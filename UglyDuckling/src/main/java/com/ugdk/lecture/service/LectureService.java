package com.ugdk.lecture.service;

import java.util.HashMap;
import java.util.List;

import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.domain.ProgressDTO;

public interface LectureService {

	public LectureDTO getLectureInfo(int idx);
	
	public List<LectureDTO> getAllLectureInfos();
	
	public boolean submitAssignment(AssignmentDTO assignmentDTO);
	
	public List<ProgressDTO> getProgressInfos(String id, int unit);

	public ProgressDTO getProgressInfo(int unitId, int contentId, String memberId);
	
	public boolean updateProgressInfo(ProgressDTO progressDTO);
	
	public boolean updateLastProgress(String id, int nextUnit);
}
