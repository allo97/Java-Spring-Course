package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> favoriteLanguageOptions;  //we want to read countries from something like database instead of hardcoding
															//so we want to get them in our constructor
	
	
	public Student() {
		
		//populate country options: used ISO country-code
		favoriteLanguageOptions = new LinkedHashMap<>();
	
		favoriteLanguageOptions.put("Java",  "Java");
		favoriteLanguageOptions.put("C#",  "C#");
		favoriteLanguageOptions.put("PHP",  "PHP");
		favoriteLanguageOptions.put("Ruby",  "Ruby");

	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public void setFavoriteLanguageOptions(LinkedHashMap<String, String> favoriteLanguageOptions) {
		this.favoriteLanguageOptions = favoriteLanguageOptions;
	}

	public LinkedHashMap<String, String> getfavoriteLanguageOptions() {
		return favoriteLanguageOptions;  //when form is loaded Spring will call student.getfavoriteLanguageOptions(); we don't need to do setCountry because we don't
	}																								// change anything
	
	
	
	
}
