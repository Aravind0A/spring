package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.registration.dto.RegistrationDto;
import com.example.registration.model.RegistrationDetails;
import com.example.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public RegistrationDetails save(RegistrationDto dto) {
		RegistrationDetails details = new RegistrationDetails(dto.getName(), dto.getPhone(), passwordEncoder.encode(dto.getPassword()));
		return registrationRepository.save(details);
	}
}
