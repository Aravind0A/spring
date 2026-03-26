package com.example.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.school.model.StudentDetails;
import com.example.school.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/create")
	public String getStudent(Model model) {
		model.addAttribute("message", "Enter Student details");
		return "create";
	}
	
	@PostMapping("/create")
	public String saveStudents(StudentDetails studentDetails, Model model) {
		
		studentRepository.save(studentDetails);
		model.addAttribute("message", "Student "+ studentDetails.getName() + " saved successfully");
		return "create";
	}
	
	@GetMapping("/all")
	public String getAllStudents(@Param("keyword")String keyword, Model model) {
		List<StudentDetails> studentDetails;
		if(keyword!=null && !keyword.isEmpty()) {
			studentDetails = studentRepository.findByName(keyword);
		} else {
			studentDetails = studentRepository.findAll();
		}
		model.addAttribute("students", studentDetails);
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable Integer id, Model model) {
		Optional<StudentDetails> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			model.addAttribute("student", optional.get());
			return "update";
		} 
		return "redirect:/all";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Integer id, Model model, StudentDetails studentDetails) {
		Optional<StudentDetails> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			StudentDetails details = optional.get();
			details.setName(studentDetails.getName());
			details.setStandard(studentDetails.getStandard());
			details.setAge(studentDetails.getAge());
			studentRepository.save(details);
		}
			return "redirect:/all";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id, Model model) {
		Optional<StudentDetails> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			model.addAttribute("student", optional.get());
			return "delete";
		} 
		return "redirect:/all";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);	
		return "redirect:/all";
	}
}
