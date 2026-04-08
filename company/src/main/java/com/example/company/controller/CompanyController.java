package com.example.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.model.CompanyDetails;
import com.example.company.repository.CompanyRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/create")
	public String getCompnay(Model model) {
		model.addAttribute("message", "Enter company details");
		return "create";
	}
	
	@PostMapping("/create")
	public String saveCompany(CompanyDetails details, Model model) {
		companyRepository.save(details);
	    model.addAttribute("message", "The company " + details.getName() +" is saved successfully");
		return "create";
		
	}
	
	@GetMapping("/all")
	public String getAll(Model model, @Param("keyword")String keyword) {
		List<CompanyDetails> details;
		if(keyword != null && !keyword.isEmpty()) {
			details = companyRepository.findAllByKeyword(keyword);
		} else {
			details = companyRepository.findAll();
		}
		model.addAttribute("company", details);
		return "list";
		
	}
}
