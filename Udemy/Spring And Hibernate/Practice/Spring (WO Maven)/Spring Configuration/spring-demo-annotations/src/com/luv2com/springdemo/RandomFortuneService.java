package com.luv2com.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data = {
			"String 1",
			"String 2",
			"String 3"
	};
	
	@Override
	public String getFortune() {
		Random rnd = new Random();
		
		return data[rnd.nextInt(data.length)];
	}

}
