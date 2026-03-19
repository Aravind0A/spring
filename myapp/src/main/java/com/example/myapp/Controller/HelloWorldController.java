package com.example.myapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
	@GetMapping("/home")
	public String redirect() {
		return "redirect:/hello";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		String message = "World is going to end";
		model.addAttribute("message",message);
		String hello = "<h1>Byee Everyone!</h1>";
		model.addAttribute("hello",hello);
		boolean isLoggedIn = true;
		model.addAttribute("loggedIn", isLoggedIn);
		return "helloWorld";
	}
	
	

}
