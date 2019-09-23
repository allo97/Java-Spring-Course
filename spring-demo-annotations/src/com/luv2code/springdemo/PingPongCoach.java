package com.luv2code.springdemo;

public class PingPongCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//Dependency Injection
	public PingPongCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "serve!";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
