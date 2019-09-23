package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = new String[] {
			"Your opponent is sick and have only 70% of his normally visibility", 
			"There was a delivery for your team and you received new faster boots!",
			"Best opponent player has a mysterious contusion and cant play!"
	};
	private Random randomNum = new Random();
	
	@Override
	public String getFortune() {
		return fortunes[randomNum.nextInt(this.fortunes.length)];
	}

}
