package com.example.productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
