package com.example.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.exception.ProductNotFoundException;
import com.example.shop.model.ProductDetails;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;

@RestController
@CrossOrigin("http://localhost:3002")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/api/addProduct")
	public ProductDetails getsaveProduct(@RequestBody ProductDetails productDetails) {
		
		return repository.save(productDetails);
	}
	
	@GetMapping("/api/getAll")
	public List<ProductDetails> getAll(){
		return repository.findAll();
	}
	
	public ProductDetails getByID(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("/api/update/{id}")
	public ProductDetails updateProduct(@PathVariable Long id, @RequestBody ProductDetails productDetails) {
		
		return repository.findById(id)
				.map(product -> {
					product.setName(productDetails.getName());
					product.setDescription(productDetails.getDescription());
					product.setExpiryDate(productDetails.getExpiryDate());
					product.setPrice(productDetails.getPrice());
					product.setCategory(productDetails.getCategory());
					return repository.save(product);
				}).orElseThrow(() -> new ProductNotFoundException(id));
			
	}
	
	@DeleteMapping("/api/{id}")
	public String deleteProduct(@PathVariable Long id) {
		
		if(!repository.existsById(id)) {
			throw new ProductNotFoundException(id);
		}
		repository.deleteById(id);
		return "Product with id "+id + " deleted";
	}
	
	@GetMapping("/api/search")
    public List<ProductDetails> searchProducts(@RequestParam("keyword") String keyword) {
        return repository.findAllByKeyword(keyword);
    }
}
