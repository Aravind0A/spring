package com.example.myapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.myapp.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

	@Query("select p.name, p.price from ProductModel p")
	List<Object[]> findNameAndPrice();
	
}
