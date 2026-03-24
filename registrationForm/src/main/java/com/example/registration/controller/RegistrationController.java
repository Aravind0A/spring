package com.example.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registration.model.UserDetails;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	 @GetMapping("/form")
	    public String processForm(Model model) {
	        UserDetails userDetails = new UserDetails();
	        model.addAttribute("userDetails", userDetails);
	        return "userDetails";
	    }
	 
	 @PostMapping("/submit")
	    public String submitForm(@Valid @ModelAttribute("userDetails") UserDetails userDetails, BindingResult result, Model model) {
	        model.addAttribute("userDetails", userDetails);
	        if (result.hasErrors()) {
	            return "userDetails";
	        } else {
	            return "success";
	        }
	    }
	
}
