package com.example.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.book.model.BookDetails;

public interface BookRepository extends JpaRepository<BookDetails, Long>{

	@Query("select b from BookDetails b where b.title LIKE %:keyword% OR b.genre LIKE %:keyword%")
	List<BookDetails> findByKeyword(@Param("keyword")String keyword);
}
