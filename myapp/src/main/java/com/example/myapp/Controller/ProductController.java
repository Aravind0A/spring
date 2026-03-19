package com.example.myapp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myapp.model.Product;

@Controller
public class ProductController {
	
	@GetMapping("/product")
	public String getProduct(Model model) {
		
		Product product = new Product(1, "apple", 50);
		model.addAttribute("product", product);
		return "product";
		
	}
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "orange", 45));
		products.add(new Product(2, "Banana", 20));
		products.add(new Product(3, "Mango", 35));
		model.addAttribute("products", products);
		return "products";
		
	}

}
