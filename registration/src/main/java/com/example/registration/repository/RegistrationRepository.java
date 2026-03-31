package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registration.model.RegistrationDetails;

public interface RegistrationRepository extends JpaRepository<RegistrationDetails, Long>{

	RegistrationDetails findByPhone(String phone);
}
