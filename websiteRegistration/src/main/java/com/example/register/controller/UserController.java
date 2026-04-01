package com.example.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.register.model.UserDetails;
import com.example.register.repository.UserReporsitory;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserReporsitory reporsitory;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDetails user) {
        user.setPassword(encoder.encode(user.getPassword()));
        reporsitory.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
