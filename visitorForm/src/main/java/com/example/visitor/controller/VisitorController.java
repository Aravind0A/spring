package com.example.visitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {

	 @GetMapping("/form")
	    public String processForm(@RequestParam(required = false) String name, @RequestParam(required = false) String age, Model model) {
	        model.addAttribute("name", name);
	        model.addAttribute("age", age); 
	        return "visitorDetails";	
	    }

	    @PostMapping("/submit")
	    public String handleFormSubmission(@RequestParam String name, @RequestParam String age,Model model) {
	        model.addAttribute("name", name);
	        model.addAttribute("age", age); 
	        return "success";
	    }
}
