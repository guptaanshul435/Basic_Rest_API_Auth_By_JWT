package com.adoptnet.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adoptnet.admin.modles.Department;
import com.adoptnet.admin.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepo depRepo;
	public ResponseEntity<List<Department>> getAllDepartments() {
		try {
			return new ResponseEntity(depRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	public ResponseEntity<Department> getDepartment(int id) {
		try {
			return new ResponseEntity(depRepo.findById(id),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
}
