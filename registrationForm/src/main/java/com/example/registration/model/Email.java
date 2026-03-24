package com.example.registration.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.registration.validator.EmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

	public String message() default "You email must contains @gmail.com"; 
    public Class<?>[] groups() default {}; 
    public Class<? extends Payload>[] payload() default {}; 
}
