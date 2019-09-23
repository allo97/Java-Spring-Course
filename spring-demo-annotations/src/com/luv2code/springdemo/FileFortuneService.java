package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	@Value("${foof.data}")
	private String[] data;
	
	
	private Random random = new Random();
	
	@PostConstruct
	public void postConstructMethod() {
		System.out.println("execute post construct in FileFortuneService");	
	}

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
