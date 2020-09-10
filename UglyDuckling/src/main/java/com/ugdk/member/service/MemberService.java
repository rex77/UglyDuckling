package com.ugdk.member.service;

import com.ugdk.member.domain.MemberDTO;

public interface MemberService {
	MemberDTO getMemberInfo(String id);
	void joinUser(MemberDTO memberDto);
}
