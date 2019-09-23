package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		//call coach properties
		
//		System.out.println("My email is: " + theCoach.getEmail());
//		System.out.println("My team is: " + theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
	