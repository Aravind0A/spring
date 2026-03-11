package com.example.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.product.model.Product;


@Controller
public class ProductController {

	@GetMapping("/single-product")
	public String getProduct(Model model) {
		
		Product product = new Product(101, "Suagr", 55.5f);
		model.addAttribute("product", product);
		return "product";
		
	}
	
	@GetMapping("/product-list")
	public String getProducts(Model model) {
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(101, "Suagr", 55.5f));
		products.add(new Product(102, "Salt", 20.0f));
		products.add(new Product(103, "Wheat flour", 38.75f));
		model.addAttribute("products", products);
		return "products";
		
	}
}
