package com.example.book.controller;

import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.book.model.BookDetails;
import com.example.book.repository.BookRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PDFController {

	 @Autowired
	 private BookRepository repository;
	    // Generate PDF for a specific product
	    @GetMapping("/pdf/{id}")
	    public void generateProductPdf(@PathVariable Long id, HttpServletResponse response) throws Exception {
	        Optional<BookDetails> optionalProduct = repository.findById(id);
	        if (optionalProduct.isPresent()) {
	            BookDetails book = optionalProduct.get();

	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment; filename=product_" + book.getId() + ".pdf");

	            try (PDDocument document = new PDDocument()) {
	                PDPage page = new PDPage();
	                document.addPage(page);

	                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, 750);
	                    contentStream.showText("Book Details");
	                    contentStream.endText();

	                    contentStream.setFont(PDType1Font.HELVETICA, 12);
	                    int yPosition = 720;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Author: " + (book.getAuthor() != null ? book.getAuthor() : "N/A"));
	                    contentStream.endText();

	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Title: " + (book.getTitle() != null ? book.getTitle() : "N/A"));
	                    contentStream.endText();

	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Price: " + (book.getPrice() != null ? book.getPrice() : "N/A"));
	                    contentStream.endText();

	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Published Date: " + (book.getPublishedDate() != null ? book.getPublishedDate() : "N/A"));
	                    contentStream.endText();
	                    
	                    yPosition -= 20;
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yPosition);
	                    contentStream.showText("Description : " + (book.getDescription() != null ? book.getDescription() : "N/A"));
	                    contentStream.endText();
	                }

	                document.save(response.getOutputStream());
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
	        }
	    }
	}