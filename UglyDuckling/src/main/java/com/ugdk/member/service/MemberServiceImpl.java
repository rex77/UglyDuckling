package com.ugdk.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ugdk.board.constant.Method;
import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.mapper.MemberMapper;
import com.ugdk.util.CommonUtils;
import com.ugdk.util.UiUtils;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDTO getMemberInfo(String id) {
		return memberMapper.getMemberInfo(id);
	}

	@Override
	public MemberDTO loadUserByUsername(String id) throws UsernameNotFoundException {
		MemberDTO member;
		member = memberMapper.getMemberInfo(id);
		if(member.equals(null))
			throw new UsernameNotFoundException(id);
		return member;
	}

	@Override
	public void joinMember(MemberDTO memberDto) {
        CommonUtils util = new CommonUtils();
        memberDto.setPassword(util.encodePassword(memberDto.getPassword()));
        memberMapper.saveMember(memberDto);
	}

	@Override
	public void updateMember(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void updateMemberWithPassword(MemberDTO memberDto, String password) {
		// TODO Auto-generated method stub
		CommonUtils util = new CommonUtils();
		String newPassword = util.encodePassword(password);
		memberDto.setPassword(newPassword);
		memberMapper.updateMemberWithPassword(memberDto);
	}
}
