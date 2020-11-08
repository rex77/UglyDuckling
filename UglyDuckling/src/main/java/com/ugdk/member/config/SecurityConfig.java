package com.ugdk.member.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.servlet.session.SessionConcurrencyDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ugdk.member.handler.CustomAuthenticationFailureHandler;
import com.ugdk.member.handler.CustomLoginSuccessHandler;
import com.ugdk.member.service.MemberServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/scripts/**", "/img/**", "/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/member/login.do")
			.successHandler(new CustomLoginSuccessHandler())
			.failureHandler(new CustomAuthenticationFailureHandler())
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and()
			.logout()
			.invalidateHttpSession(false)
			.logoutSuccessUrl("/member/logout.do?type=normal")
			.permitAll()
		.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.invalidSessionUrl("/member/logout.do?type=sessionDestroyed");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberServiceImpl).passwordEncoder(passwordEncoder());
	}
	
}
