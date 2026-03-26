package com.example.mobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mobile.model.MobileDetails;
import com.example.mobile.repository.MobileRepository;

@Controller
public class MobileController {

	@Autowired
	private MobileRepository mobileRepository;
	
	@GetMapping("/getMobile")
	public String getMobile(Model model) {
		model.addAttribute("message", "Enter the details");
		return "mobile";
	}
	
	@GetMapping("/getMobiles")
	public String getAllMobiles(Model model) {
		Iterable<MobileDetails> mobileList = mobileRepository.findAll();
		model.addAttribute("mobileList", mobileList);
		return "mobileList";
		
	}
	
	@PostMapping("/save-mobile")
	public String saveMobile(MobileDetails mobileDetails, Model model) {
		MobileDetails mobileDetails2 = new MobileDetails();
		mobileDetails2.setName(mobileDetails.getName());
		mobileDetails2.setBrand(mobileDetails.getBrand());
		mobileDetails2.setPrice(mobileDetails.getPrice());
		mobileDetails2.setType(mobileDetails.getType());
		mobileRepository.save(mobileDetails2);
		model.addAttribute("mobiledetails", mobileDetails2);
		return "mobile";
	}
	
	
	@GetMapping("/getName&Price")
	public String getMobileNameAndPrice(Model model) {
		List<Object[]> listMobileDetails = mobileRepository.findAllMobileNameAndPrice();
		model.addAttribute("nameandprice", listMobileDetails);
		return "mobilenameprice";
	}
	
	@GetMapping("/getByPrice")
	public String getByPrice(Model model) {
		List<MobileDetails> lisDetails = mobileRepository.findByPrice();
		model.addAttribute("nameandprice", lisDetails);
		return "mobileprice";
	}
	
	@GetMapping("/getByType")
	public String getByType(Model model) {
		List<Object[]> listByType = mobileRepository.findByType();
		model.addAttribute("byType", listByType);
		return "mobileType";
	}
	
	@GetMapping("/create")
	public String createMobile(Model model) {
		model.addAttribute("message","Enter the details");
		return "create";
	}
	
	@PostMapping("/create")
	public String saveMobileDetails(MobileDetails mobileDetails, Model model) {
		mobileRepository.save(mobileDetails);
		model.addAttribute("mobile", "Mobile "+mobileDetails.getName() + " saved successfully");
		return "create";
	}
	
	@GetMapping("/all")
	public String getAllMobile(Model model) {
		List<MobileDetails> mobileDetails;
		mobileDetails = mobileRepository.findAll();
		model.addAttribute("mobileList", mobileDetails);
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String updateMobile(@PathVariable Integer id, MobileDetails mobileDetails, Model model){
		
		Optional<MobileDetails> optional = mobileRepository.findById(id);
		if(optional.isPresent()) {
			model.addAttribute("mobile", optional.get());
			return "update";
		}
		return "redirect:/all";
	}
	
	@PostMapping("/update/{id}")
	public String updateMobil(@PathVariable Integer id, MobileDetails mobileDetails, Model model){
		
		Optional<MobileDetails> optional = mobileRepository.findById(id);
		if(optional.isPresent()) {
			MobileDetails details = optional.get();
			details.setName(mobileDetails.getName());
			details.setBrand(mobileDetails.getBrand());
			details.setPrice(mobileDetails.getPrice());
			mobileRepository.save(details);
		}
		return "redirect:/all";
	}
			
	  @GetMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Integer id, Model model) {
	        Optional<MobileDetails> optional = mobileRepository.findById(id);
	        if (optional.isPresent()) {
	            model.addAttribute("mobile", optional.get());
	            return "delete";
	        }
	        return "redirect:/all"; // Handle not found case
	    }

	    @PostMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Integer id) {
	        mobileRepository.deleteById(id);
	        return "redirect:/all";
	    }
}
