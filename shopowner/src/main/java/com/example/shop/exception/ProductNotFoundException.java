package com.example.shop.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(Long id){
        super("Could not found the product with id "+ id);
    }
}
