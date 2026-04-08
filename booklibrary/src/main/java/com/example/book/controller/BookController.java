package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book.model.BookDetails;
import com.example.book.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/all")
	public String saveBook(Model model) {
		
		BookDetails details = new BookDetails();
		details.setAuthor("Oda");
		details.setTitle("One piece");
		details.setDescription("find one piece");
		details.setPrice("560");
		details.setPublishedDate("02/10/1996");
		model.addAttribute("book", details);
		repository.save(details);
		return "list";
	}
	
}
