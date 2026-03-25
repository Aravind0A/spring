package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.restaurant.model.DishDetails;

@Controller
public class DishController {

	@GetMapping("/dish/{dishName}/{price}")
	public String getDish(@PathVariable String dishName, @PathVariable Float price, Model model){
		
		DishDetails details = new DishDetails();
		details.setDishName(dishName);
		details.setPrice(price);
		model.addAttribute("dish", details);
		return "dish";
	}
}
