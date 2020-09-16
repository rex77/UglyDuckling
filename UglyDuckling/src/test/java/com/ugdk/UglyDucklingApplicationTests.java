package com.ugdk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ugdk.member.service.MemberService;

@SpringBootTest
class UglyDucklingApplicationTests {
	@Autowired
	MemberService memberService;

	@Test
	void contextLoads() {
	System.out.println(memberService.getMemberInfo("s2rlight").getPassword());
	}

}
