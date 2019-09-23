package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		//Coach theCoach = context.getBean("swimCoach", Coach.class);  //when we don't use specifically Coach properties
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call coach properties
		System.out.println("My email is: " + theCoach.getEmail());
		System.out.println("My team is: " + theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
	