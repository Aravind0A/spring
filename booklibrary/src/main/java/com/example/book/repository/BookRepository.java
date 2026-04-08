package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.model.BookDetails;

public interface BookRepository extends JpaRepository<BookDetails, Long>{

}
