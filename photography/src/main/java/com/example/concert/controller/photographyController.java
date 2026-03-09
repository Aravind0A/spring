package com.example.concert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class photographyController {
	
	
	@GetMapping("/welcome")
	public String displayPhoto() {
		return "photography";
		
	}
	
	@GetMapping("/start")
	public String redirect() {
		return "redirect:/welcome";
		
	}
	
	@GetMapping("/vegetables")
	public String displayVegetables() {
		return "vegetables";
		
	}

}
