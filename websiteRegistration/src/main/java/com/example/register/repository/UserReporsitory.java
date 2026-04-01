package com.example.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.register.model.UserDetails;

public interface UserReporsitory extends JpaRepository<UserDetails, Long>{

	
}
