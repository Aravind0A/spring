package com.example.myapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@GetMapping("/home")
	public String redirect() {
		return "redirect:/hello";
		
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "helloWorld";
		
		
	}

}
