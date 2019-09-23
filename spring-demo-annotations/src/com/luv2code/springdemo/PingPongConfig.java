package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PingPongConfig {

	@Bean
	public FortuneService magicPaddleFortuneService() {
		return new MagicPaddleFortuneService();
	}
	
	@Bean
	public Coach pingPongCoach() {
		return new PingPongCoach(magicPaddleFortuneService());
	}
}
