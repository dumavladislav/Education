package com.luv2com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2com.springdemo")
@PropertySource("classpath:application.properties")
public class SportConfig {

	// define bean for our sad fortune service
	
	@Bean
	public FortuneService sadFortuneService() {
		return new FileFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}
