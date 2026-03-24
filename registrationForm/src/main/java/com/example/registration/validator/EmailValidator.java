package com.example.registration.validator;


import com.example.registration.model.Email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		value = value.toLowerCase();
		boolean isValue = value.contains("@gmail.com");
		return isValue;
	}

}
