package com.example.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.myapp.dto.UserDto;
import com.example.myapp.model.User;
import com.example.myapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	public User saveDto(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		return userRepository.save(user);
	}
}
