package com.example.myapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.model.ProductModel;
import com.example.myapp.repository.ProductRepository;

@Controller
public class ProductModelController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/create")
	public String Product(Model model) {
		model.addAttribute("message", "Enter product details");
		return "create";
	}
	
	@PostMapping("/create")
	public String saveProduct(ProductModel productModel, Model model) {
		productRepository.save(productModel);
	    model.addAttribute("message", "The product " + productModel.getName() +" is saved successfully");
		return "create";
		
	}
	
	@GetMapping("/all")
	public String getAll(Model model, @Param("keyword")String keyword) {
		List<ProductModel> productModels;
		if(keyword != null && !keyword.isEmpty()) {
			productModels = productRepository.findAllByKeyword(keyword);
		} else {
			productModels = productRepository.findAll();
		}
		model.addAttribute("products", productModels);
		return "list";
		
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateProduct(@PathVariable Integer id, Model model){
		Optional<ProductModel> proOptional = productRepository.findById(id);
		if(proOptional.isPresent()) {
			model.addAttribute("productDetails", proOptional.get());
			return "update";
		}
		return "redirect:/all";
	}
	
	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable Integer id, ProductModel productModel) {
		Optional<ProductModel> proOptional = productRepository.findById(id);
		if(proOptional.isPresent()) {
			ProductModel productModel2 = proOptional.get();
			productModel2.setName(productModel.getName());
			productModel2.setDescription(productModel.getDescription());
			productModel2.setExpirydate(productModel.getExpirydate());
			productModel2.setPrice(productModel.getPrice());
			productRepository.save(productModel2);
		}
		return "redirect:/all";
	}
	
	  @GetMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Integer id, Model model) {
	        Optional<ProductModel> optionalProductDetails = productRepository.findById(id);
	        if (optionalProductDetails.isPresent()) {
	            model.addAttribute("productDetails", optionalProductDetails.get());
	            return "delete";
	        }
	        return "redirect:/all"; // Handle not found case
	    }

	    @PostMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Integer id) {
	        productRepository.deleteById(id);
	        return "redirect:/all";
	    }
	
	@GetMapping("/productsmodel")
	public String showProducts(Model model) {
		 Iterable<ProductModel> productList = productRepository.findAll();
	    model.addAttribute("productsmodel", productList);
	    return "productsmodel";
	}
	
	
}
