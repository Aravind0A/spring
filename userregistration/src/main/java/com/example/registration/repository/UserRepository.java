package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registration.model.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Long>{

	UserRegistration findByEmail(String email);
}
