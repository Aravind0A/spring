package com.example.myapp.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.exception.ProductNotFoundException;
import com.example.myapp.model.ProductModel;
import com.example.myapp.repository.ProductRepository;

@RestController
@CrossOrigin("http://localhost:3002")
public class ProductApiController {

	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/api/addProduct")
	ProductModel newProduct(@RequestBody ProductModel product) {
		return repository.save(product);
	}
	
	@GetMapping("/api/listProducts")
	List<ProductModel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/api/{id}")
	ProductModel getById(@PathVariable Integer id) {
		
		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("api/updateproduct/{id}")
    ProductModel updateProduct(@RequestBody ProductModel newProduct, @PathVariable Integer id) {
        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setExpirydate(newProduct.getExpirydate());
                    return repository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }
	
	@DeleteMapping("api/deleteproduct/{id}")
    String deleteProduct(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
        return  "Product with id "+id+" has been deleted successfully.";
    }
	
	@GetMapping("api/search")
    List<ProductModel> searchProducts(@Param("keyword") String keyword) {
        return repository.findAllByKeyword(keyword);
    }
}
