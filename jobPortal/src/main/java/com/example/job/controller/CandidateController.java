package com.example.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.job.dto.CandidateDto;
import com.example.job.service.CandidateService;

@Controller
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("candidate")CandidateDto dto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveDetails(@ModelAttribute("candidate")CandidateDto dto, Model model) {
		candidateService.saveDetails(dto);
		model.addAttribute("message", "Thanks for registering, " + dto.getFullname()+ " ! You can now apply for jobs.");
		return "register";
		
	}
}
