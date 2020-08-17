package com.ugdk.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDTO getMemberInfo(int idx) {
		return memberMapper.getMemberInfo(idx);
	}

}
