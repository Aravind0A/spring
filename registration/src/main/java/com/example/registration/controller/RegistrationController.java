package com.example.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registration.dto.RegistrationDto;
import com.example.registration.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("register")RegistrationDto registrationDetails) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveDetails(@ModelAttribute("register")RegistrationDto dto, Model model) {
		
		registrationService.save(dto);
		model.addAttribute("message", "Registered Successfully");
		return "register";
	}
	
	@GetMapping("/welcome")
	public String display(Model model) {
		model.addAttribute("message", model);
		return "welcome";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
}
