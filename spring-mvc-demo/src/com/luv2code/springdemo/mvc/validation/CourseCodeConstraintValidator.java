package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		Boolean result = false;
		
		if(theCode != null) {
			
			for(String prefix : coursePrefixes) {
				result = theCode.startsWith(prefix);
				
				if(result) {
					break;
				}
			}
		}
		
		
		return result;
	}

}
