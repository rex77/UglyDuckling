package com.ugdk.member.service;

import com.ugdk.member.domain.MemberDTO;

public interface MemberService {
	MemberDTO getMemberInfo(String id);
	void joinMember(MemberDTO memberDto);
	public void updateMember (MemberDTO memberDto);
	public void updateMemberWithPassword (MemberDTO memberDto, String password);
}
