package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.model.CandidateDetails;

public interface CandidateRepository extends JpaRepository<CandidateDetails, Long>{
	
	CandidateDetails findByEmail(String email);

}
