package com.example.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.model.ProductModel;
import com.example.myapp.repository.ProductRepository;

@Controller
public class ProductModelController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/productmodel")
	public String Product(Model model) {
		model.addAttribute("message", "Enter product details");
		return "productmodel";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(ProductModel productModel, Model model) {
		
		ProductModel productModel2 = new ProductModel();
		productModel2.setName(productModel.getName());
		productModel2.setDescription(productModel.getDescription());
		productModel2.setPrice(productModel.getPrice());
		
		productRepository.save(productModel2);
	    model.addAttribute("message", "The product " + productModel.getName() +" is saved successfully");

		return "productmodel";
		
	}
	
	@GetMapping("/productsmodel")
	public String showProducts(Model model) {
		 Iterable<ProductModel> productList = productRepository.findAll();
	    model.addAttribute("productsmodel", productList);
	    return "productsmodel";
	}

}
