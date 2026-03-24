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
	private BookRepository bookRepository;

	@GetMapping("/book")
	public String getBooks(Model model) {
		model.addAttribute("message", "enter your book");
		return "book";
	}
	
	@GetMapping("/books")
	public String getAllBooks(Model model) {
		Iterable<BookDetails> bookIterable = bookRepository.findAll();
		model.addAttribute("books", bookIterable);
		return "books";
	}
	
	@PostMapping("/save-book")
	public String saveBooks(BookDetails bookDetails, Model model) {
		BookDetails details = new BookDetails();
		details.setAuthor(bookDetails.getAuthor());
		details.setTitle(bookDetails.getTitle());
		details.setPrice(bookDetails.getPrice());
		bookRepository.save(details);
		model.addAttribute("message", "Book "+ bookDetails.getTitle()+ " saved successfully");
		return "book";
		
	}
}
