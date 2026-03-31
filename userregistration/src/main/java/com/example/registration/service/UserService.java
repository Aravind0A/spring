package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.registration.dto.UserDto;
import com.example.registration.model.UserRegistration;
import com.example.registration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserRegistration save(UserDto userDto) {
		UserRegistration user = new UserRegistration(userDto.getfName(), userDto.getlName(), userDto.getAddress(),
				userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(user);
	}
}

