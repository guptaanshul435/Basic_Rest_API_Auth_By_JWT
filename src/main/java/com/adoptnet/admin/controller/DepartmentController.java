package com.adoptnet.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptnet.admin.modles.Department;
import com.adoptnet.admin.services.DepartmentService;

@RestController
@RequestMapping("departments")
public class DepartmentController {

	
	@Autowired
	DepartmentService departmentSer;
	
	@GetMapping("departments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return departmentSer.getAllDepartments();
	}
	
	@GetMapping("deparment/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable int id){
		return departmentSer.getDepartment(id);
		
	}
	
	
	
}
