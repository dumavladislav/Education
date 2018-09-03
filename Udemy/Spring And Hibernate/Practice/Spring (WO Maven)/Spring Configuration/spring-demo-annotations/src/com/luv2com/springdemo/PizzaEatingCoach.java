package com.luv2com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PizzaEatingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Eat 5 meat pizzas at 13:00. 7 pizzas at 16:00 and 18 pizzas at 20:00";
	}

	@Override
	public String getDailyFortune() {
		
		return null;
	}
	
}
