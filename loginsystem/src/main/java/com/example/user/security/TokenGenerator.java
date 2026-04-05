package com.example.user.security;

import java.security.SecureRandom;

import javax.xml.stream.events.Characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.model.UserDetails;
import com.example.user.repository.UserRepository;

@Service
public class TokenGenerator {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 60;
    private static final SecureRandom RANDOM = new SecureRandom();
    
    private String generateRandomString() {
    	StringBuilder builder = new StringBuilder(TOKEN_LENGTH);
    	
    	for(int i=0; i< TOKEN_LENGTH; i++ ) {
    		
    		int randomIndex = RANDOM.nextInt(CHARACTERS.length());
    	builder.append(CHARACTERS.charAt(randomIndex));
    	}
    	return builder.toString();
    }
    
    public String generateToken(String email, String password) {
    	
    	UserDetails user = userRepository.findByEmail(email);
    	
    	if(user!= null && passwordEncoder.matches(password, user.getPassword())) {
    		String token;
    		
    		do {
    			token = generateRandomString();
    			
    		}while(userRepository.existsByToken(token));
    		user.setToken(token);
    		userRepository.save(user);
    		return token;
    	}
    	return null;
    }
    
    public boolean validateToken(String token) {
    	UserDetails user = userRepository.findByToken(token);
    	return user != null;
    }
    
    public void invalidateToken(String token) {
        UserDetails user = userRepository.findByToken(token);
        if (user != null) {
            user.setToken(null);
            userRepository.save(user);
        }
    }
}
