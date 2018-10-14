package com.luv2com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("Same objects: " + (theCoach == alphaCoach));
		
		System.out.println("Address theCoach: " + theCoach.toString());
		System.out.println("Address alphaCoach: " + alphaCoach.toString());
		
		// close context
		context.close();
		
	}

}
