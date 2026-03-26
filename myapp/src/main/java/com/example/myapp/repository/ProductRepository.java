package com.example.myapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.myapp.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {


    @Query("SELECT p FROM ProductModel p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
	List<ProductModel> findAllByKeyword(@Param("keyword") String keyword);
	
}
