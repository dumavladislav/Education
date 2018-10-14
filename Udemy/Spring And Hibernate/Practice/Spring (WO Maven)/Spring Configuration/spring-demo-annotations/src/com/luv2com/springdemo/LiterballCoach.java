package com.luv2com.springdemo;

public class LiterballCoach implements Coach {

	private FortuneService fortuneService;
	
	public LiterballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Drink a lot of beers!! It's friday!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
