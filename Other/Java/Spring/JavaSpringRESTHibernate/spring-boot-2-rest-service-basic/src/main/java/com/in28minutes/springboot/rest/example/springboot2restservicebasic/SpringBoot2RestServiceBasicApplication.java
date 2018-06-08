package com.in28minutes.springboot.rest.example.springboot2restservicebasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages = { "com.in28minutes.springboot.rest.example.student"} )
//@Configuration
//@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan("com.in28minutes.springboot.rest.example.student")
@EntityScan(value = "com.in28minutes.springboot.rest.example.student")
@EnableJpaRepositories(basePackages={"com.in28minutes.springboot.rest.example.student"})//Path of your CRUD repositories package
@PropertySource("classpath:application.properties")

public class SpringBoot2RestServiceBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2RestServiceBasicApplication.class, args);
	}
}
