package com.example.studentinfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.studentinfo.model.StudentInfo;

@Controller
public class StudentController {
	
	@GetMapping("/student-info")
	public String getStudent(Model model) {
		
		StudentInfo studentInfo = new StudentInfo(101, "Aravind", 87.5f);
		model.addAttribute("student", studentInfo);
		return "student";
		
	}
	
	@GetMapping("/student-list")
	public String getStudents(Model model) {
		
		List<StudentInfo> studentInfos = new ArrayList<>();
		studentInfos.add(new StudentInfo(101, "Aravind", 87.5f));
		studentInfos.add(new StudentInfo(102, "Gokul", 90.7f));
		studentInfos.add(new StudentInfo(103, "Nithin", 91.8f));
		model.addAttribute("students", studentInfos);
		return "students";
		
	}

}
