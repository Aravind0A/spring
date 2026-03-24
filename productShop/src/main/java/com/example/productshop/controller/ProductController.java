package com.example.productshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productshop.model.Product;
import com.example.productshop.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/newproduct")
	public String getProduct(Model model) {
		
		model.addAttribute("message", "enter the products");
		return "product";
		
	}
	@GetMapping("/products")
	public String showProducts(Model model) {
		 Iterable<Product> productList = productRepository.findAll();
	    model.addAttribute("products", productList);
	    return "products";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(Product product, Model model) {
		
		Product product2 = new Product();
		product2.setName(product.getName());
		product2.setDescription(product.getDescription());
		product2.setPrice(product.getPrice());
		productRepository.save(product2);
        model.addAttribute("message", "The product " + product.getName() +" is saved successfully");
		return "product";
		
	}
}
