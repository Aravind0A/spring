package com.example.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.company.model.CompanyDetails;
import com.example.company.repository.CompanyRepository;

@Controller
public class MailController {

	
		@Autowired
	    private JavaMailSender sender;

	    @Autowired
	    private CompanyRepository companyRepository;

	    // Send email with product details
	    @GetMapping("/email/{id}")
	    @ResponseBody
	    public String sendEmail(@PathVariable Long id) {
	        try {
	            // Fetch product from the database
	            CompanyDetails company = companyRepository.findById(id).orElse(null);
	            
	            if (company == null) {
	                return "Company not found!";
	            }

	            // Prepare the email content
	            SimpleMailMessage msg = new SimpleMailMessage();
	            msg.setTo("receiver@mailtrap.io");  // Replace with your Mailtrap address or receiver's email
	            msg.setSubject("Company Details: " + company.getName());
	            msg.setText("Company Name: " + company.getName() + "\n"
	                    + "Email: " + company.getEmail() + "\n"
	                    + "Address: " + company.getAddress());

	            // Send the email
	            sender.send(msg);
	            return "Successfully sent email for company: " + company.getName();
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	            return "Sending email failed";
	        }
	    }
	}