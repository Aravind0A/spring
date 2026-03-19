package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.book.model.BookDetails;

@Controller
public class BookController {

	@GetMapping("/home")
	public String bookHome() {
		return "book";
		
	}
	
	@GetMapping("/books")
	public String displayBooks(Model model) {
		BookDetails book = new BookDetails("DBZ", "Toriyama", 50);
		model.addAttribute("book", book);
		return "books";
		
	}
}
