package com.example.company.controller;

import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.company.model.CompanyDetails;
import com.example.company.repository.CompanyRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PdfController {
	
	 	@Autowired
	    private CompanyRepository companyRepository;
	    // Generate PDF for a specific product
	    @GetMapping("/pdf/{id}")
	    public void generateProductPdf(@PathVariable Long id, HttpServletResponse response) throws Exception {
	        Optional<CompanyDetails> optionalProduct = companyRepository.findById(id);
	        if (optionalProduct.isPresent()) {
	            CompanyDetails details = optionalProduct.get();

	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment; filename=company_" + details.getId() + ".pdf");

	            try (PDDocument document = new PDDocument()) {
	                PDPage page = new PDPage();
	                document.addPage(page);

	                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, 750);
	                    contentStream.showText("Company Details");
	                    contentStream.endText();

	                    contentStream.setFont(PDType1Font.HELVETICA, 12);
	                    int yPosition = 720;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Name: " + (details.getName() != null ? details.getName() : "N/A"));
	                    contentStream.endText();

	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Email: " + (details.getEmail() != null ? details.getEmail() : "N/A"));
	                    contentStream.endText();

	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Address: " + (details.getAddress() != null ? details.getAddress() : "N/A"));
	                    contentStream.endText();

	                }

	                document.save(response.getOutputStream());
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Company not found");
	        }
	    }
	}