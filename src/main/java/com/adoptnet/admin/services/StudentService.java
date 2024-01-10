package com.adoptnet.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adoptnet.admin.modles.Student;
import com.adoptnet.admin.repo.StudentRepo;

@Service
public class StudentService {

	
	@Autowired
	StudentRepo stuRepo;
	
	
	public ResponseEntity<List<Student>> getAllStudents() {
		try
		{
			return new ResponseEntity(stuRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


//	public ResponseEntity<List<Student>> getStudentsByDepartment(int id) {
//		try {
//			return new ResponseEntity(stuRepo.findByDepartment_id(id),HttpStatus.OK);
//		}catch (Exception e) {
//			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	
	
}
