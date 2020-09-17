package com.ugdk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UglyDucklingApplication extends SpringBootServletInitializer {

	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(UglyDucklingApplication.class);
	  }
	 
	public static void main(String[] args) {
		SpringApplication.run(UglyDucklingApplication.class, args);
	}

}
