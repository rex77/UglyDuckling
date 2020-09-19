package com.ugdk.lecture.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ugdk.lecture.domain.AssignmentDTO;
import com.ugdk.lecture.domain.LectureDTO;
import com.ugdk.lecture.domain.ProgressDTO;

@Mapper
public interface LectureMapper {
	public LectureDTO getLectureInfo(int idx);
	
	public List<LectureDTO> getAllLectureInfos();
	
	public boolean submitAssignment(AssignmentDTO assignmentDTO);

	public List<ProgressDTO> getProgressInfos(HashMap<String,Object> param);
	
	public ProgressDTO getProgressInfo(HashMap<String, Object> map);
	
	public boolean insertProgressInfo(ProgressDTO progressDTO);
	
	public boolean updateProgressInfo(ProgressDTO progressDTO);
}
