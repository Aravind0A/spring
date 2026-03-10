package com.example.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class movieController {

	@GetMapping("/movie")
	public String movie(Model model) {
		
		String movieTitle = "Spider man";
		String movieDecription = "Spider-Man is a superhero in American comic books published by Marvel Comics.";
		String movieFullDecription = "Spider-Man is a superhero in American comic books published by "
				+ "Marvel Comics. Created by writer-editor Stan Lee and "
				+ "artist Steve Ditko, he first appeared in the anthology comic book";
		
		boolean isLoggedIn = false;
		
		model.addAttribute("movieTitle", movieTitle);
		model.addAttribute("movieDescription", movieDecription);
		model.addAttribute("movieFullDecription", movieFullDecription);
		model.addAttribute("loggedIn", isLoggedIn);
		return "movieTitle";
		
	}
}
