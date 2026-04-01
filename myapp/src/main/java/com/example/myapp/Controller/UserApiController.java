package com.example.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.User;
import com.example.myapp.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserApiController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user){
		
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return ResponseEntity.ok("User registered successfully");
	}
}
