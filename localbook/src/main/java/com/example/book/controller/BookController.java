package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.book.exception.BookNotFoundException;
import com.example.book.model.BookDetails;
import com.example.book.repository.BookRepository;

@RestController
@CrossOrigin("http://localhost:3002")
public class BookController {


	@Autowired
	private BookRepository repository;
	
	@PostMapping("api/addBook")
    BookDetails newBook(@RequestBody BookDetails bookDetails) {
        return repository.save(bookDetails);
    }


    @GetMapping("api/listBook")
    List<BookDetails> getAllBooks() {
        return repository.findAll();
    }
    
    @GetMapping("api/book/{id}")
    BookDetails getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
    
    @PutMapping("api/update/{id}")
    BookDetails updateBook(@RequestBody BookDetails bookDetails, @PathVariable Long id) {
        return repository.findById(id)
                .map(book -> {
                	book.setTitle(bookDetails.getTitle());
                	book.setAuthor(bookDetails.getAuthor());
                	book.setGenre(bookDetails.getGenre());
                	book.setPrice(bookDetails.getPrice());
                	book.setPublishedDate(bookDetails.getPublishedDate());
                    return repository.save(book);
                }).orElseThrow(() -> new BookNotFoundException(id));
    }
    
    @DeleteMapping("api/delete/{id}")
    String deleteBook(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        repository.deleteById(id);
        return  "Book with id "+id+" has been deleted successfully.";
    }
    
    @GetMapping("api/search")
    List<BookDetails> searchProducts(@Param("keyword") String keyword) {
        return repository.findByKeyword(keyword);
    }

}
