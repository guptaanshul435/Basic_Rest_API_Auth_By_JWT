package com.adoptnet.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptnet.admin.modles.Student;
import com.adoptnet.admin.services.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService stuSer;
	
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return stuSer.getAllStudents();
		
	}
	
}
