package com.luv2com.springdemo;

public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "REST Fortune";
	}

}
