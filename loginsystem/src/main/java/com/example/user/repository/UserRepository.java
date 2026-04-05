package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
	
	 UserDetails findByEmail(String email);
	    UserDetails findByToken(String token);
	    boolean existsByToken(String token);

}
