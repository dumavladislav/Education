package com.luv2com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigClass {
	
	@Bean
	public FortuneService qqqFortuneService() {
		return new MyQQQFortunerService();
	}
	
	@Bean
	public Coach literballCoach() {
		return new LiterballCoach(qqqFortuneService());
	}

}
