package com.ugdk.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ugdk.member.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO getMemberInfo(int idx);
}
