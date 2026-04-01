package com.example.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.register.model.UserDetails;
import com.example.register.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody UserDetails details){
		
		details.setPassword(encoder.encode(details.getPassword()));
		repository.save(details);
		ResponseEntity.ok("User registered successfully ");
		return "User "+details.getfName() + " "+ details.getEmail();
	}
}
