package com.example.myapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myapp.model.UserDetails;

import jakarta.validation.Valid;


@Controller
public class FormController {
	
	@GetMapping("/form")
	public String processForm(Model model) {
		
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
		  UserDetails userDetails = new UserDetails();
	      model.addAttribute("userDetails", userDetails);
	      return "userDetails";
	}
	
//	 	@PostMapping("/submit")
//	    public String handleFormSubmission(@RequestParam String name, @RequestParam String email,Model model) {
//	        model.addAttribute("name", name);
//	        model.addAttribute("email", email); 
//	        return "success";
//	    }
//	 	
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
