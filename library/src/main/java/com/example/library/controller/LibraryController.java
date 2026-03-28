package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library.dto.LibraryDto;
import com.example.library.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	 @GetMapping("/registration")
	    public String getRegistrationPage(@ModelAttribute("library") LibraryDto libraryDto) {
	        return "register";
	    }
	    
	    @PostMapping("/registration")
	    public String saveUser(@ModelAttribute("library") LibraryDto libraryDto, Model model) {
	        libraryService.save(libraryDto);
	        model.addAttribute("message", "Welcome, "+ libraryDto.getName() + " ! Your library membership has been created");
	        return "register";
	    }
}
