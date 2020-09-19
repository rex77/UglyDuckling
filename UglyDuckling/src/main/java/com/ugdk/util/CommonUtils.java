package com.ugdk.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {
	public String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
	}
}
