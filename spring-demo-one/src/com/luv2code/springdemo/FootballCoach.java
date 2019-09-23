package com.luv2code.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Just kick the freaking ball!!!";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("FootballCoach: inside method doMyStartupStuff");
	}
	//add destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("FootballCoach: inside method doMyCleanupStuffYoYo");
	}
	

}
