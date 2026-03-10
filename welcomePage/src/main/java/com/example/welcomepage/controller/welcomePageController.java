package com.example.welcomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomePageController {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		String heading = "Welcome to learnign website";
		model.addAttribute("heading", heading);
		String hello = "<h1>Hello from Spring Boot!</h1>";
		model.addAttribute("hello", hello);
		boolean isLoggeIn = false;
		model.addAttribute("loggedIn", isLoggeIn);
		return "welcomePage";
		
	}

}
