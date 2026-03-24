package com.example.registration.validator;

import com.example.registration.model.Address;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<Address, String>{

	@Override
	public boolean isValid(String s, ConstraintValidatorContext context) {
		s= s.toLowerCase();
		boolean isValid = s.contains("india");
		return isValid;
	}

}
