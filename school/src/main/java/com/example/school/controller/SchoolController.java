package com.example.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchoolController {

	
	@GetMapping("/home")
	public String homePage() {
		return "school";
		
	}
}
