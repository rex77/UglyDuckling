package com.ugdk.member.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.ugdk.member.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO getMemberInfo(String id);
	public void saveMember(MemberDTO memberDto);
}
