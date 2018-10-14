package com.luv2com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LiterballTesting {

	public static void main(String[] args) {
		
		// load spring configuration class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyConfigClass.class);
		
		// retrieve the bean
		
		Coach theCoach = context.getBean("literballCoach", Coach.class);
		
		// do something
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
		
	}

}
