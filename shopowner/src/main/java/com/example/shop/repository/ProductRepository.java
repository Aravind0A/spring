package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shop.model.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Long>{

	@Query("SELECT p FROM ProductDetails p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
	List<ProductDetails> findAllByKeyword(@RequestParam("keyword")String keyword);

}
