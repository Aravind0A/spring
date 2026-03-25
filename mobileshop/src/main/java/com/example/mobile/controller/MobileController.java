package com.example.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
