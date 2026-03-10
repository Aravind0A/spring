package com.example.concert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class portfolioController {
	
	
	@GetMapping("/portfolio")
	public String displayPortfolio() {
		return "portfolio";
	}
	
	@GetMapping("/start")
	public String redirect() {
		return "redirect:/portfolio";
		
	}

}
