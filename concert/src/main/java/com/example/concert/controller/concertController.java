package com.example.concert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class concertController {
	
	
	@GetMapping("/concert")
	public String displayConcert() {
		return "concertWelcome";
		
	}

}
