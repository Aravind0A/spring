package com.example.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.registration.model.RegistrationDetails;
import com.example.registration.repository.RegistrationRepository;

@Service
public class CustomRegistrationService implements UserDetailsService{
	
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		RegistrationDetails register = registrationRepository.findByPhone(username);
		if(register == null) {
			throw new UsernameNotFoundException("USer not found");
		}
		return new CustomRegister(register);
	}

}
