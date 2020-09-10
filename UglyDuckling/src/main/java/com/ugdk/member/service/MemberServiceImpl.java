package com.ugdk.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ugdk.member.domain.MemberDTO;
import com.ugdk.member.mapper.MemberMapper;

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
	public void joinUser(MemberDTO memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberMapper.saveMember(memberDto);
	}

	

}
