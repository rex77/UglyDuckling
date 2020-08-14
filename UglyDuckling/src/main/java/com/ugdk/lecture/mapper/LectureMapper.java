package com.ugdk.lecture.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ugdk.lecture.domain.LectureDTO;

@Mapper
public interface LectureMapper {
	public LectureDTO getLectureInfo(int idx);
	
	public List<LectureDTO> getAllLectureInfos();
}
