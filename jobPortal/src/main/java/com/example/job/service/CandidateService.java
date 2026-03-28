package com.example.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.job.dto.CandidateDto;
import com.example.job.model.CandidateDetails;
import com.example.job.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CandidateRepository candidateRepository;
	
	public CandidateDetails saveDetails(CandidateDto candidateDto) {
		CandidateDetails details = new CandidateDetails(candidateDto.getFullname(), candidateDto.getEmail(),
										candidateDto.getMobile(), passwordEncoder.encode(candidateDto.getPassword()));
		return candidateRepository.save(details);
		
	}
}
