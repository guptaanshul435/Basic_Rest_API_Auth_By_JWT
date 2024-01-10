package com.adoptnet.admin.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adoptnet.admin.modles.Admin;

import com.adoptnet.admin.repo.AdminRepo;


@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	
//	Admin admin=new Admin(13,"Anshul", "fatehabad", null);
//	Department dep=new Department(12,"Computer","MCA",admin, null);
//	List<Department> listdepa=new ArrayList<>();
//	Student stu=new Student(12, "ravi", dep);
//	List<Student> studentlist=new ArrayList<>();
	
	
//	public void setData() {
//		listdepa.add(dep);
//		studentlist.add(stu);
//		admin.setDepartment(listdepa);
//		dep.setStudent(studentlist);
//		adminRepo.save(admin);
//	}


	public ResponseEntity<Admin> getDataById(int i) {
		try {
			return new ResponseEntity(adminRepo.findById(i),HttpStatus.OK);	
		}catch (Exception e) {
			return new ResponseEntity("Request got failed :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}


	public ResponseEntity<String> postData(Admin admin) {
	    try {
	    	return new ResponseEntity(adminRepo.save(admin), HttpStatus.CREATED);
	    }catch (Exception e) {
			return new ResponseEntity<String>("Create Got Failed:"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public ResponseEntity<String> updateAdmin(Admin admin2,int id) {
		try {
			Optional<Admin> optAdmin=adminRepo.findById(id);
			Admin admin=optAdmin.get();
			admin.setAddress(admin2.getAddress());
			admin.setName(admin2.getName());
			admin.setDepartment(admin2.getDepartment());
			adminRepo.saveAndFlush(admin);
			return new ResponseEntity(admin2+"",HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity("Update Got Failed:"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}


	public ResponseEntity<List<Admin>> geAllAdmins() {
		try {
			return new ResponseEntity(adminRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}


	public ResponseEntity<String> removeAdmin(int id) {
		try {
			adminRepo.deleteById(id);
			return new ResponseEntity("Data is removed Sucessfully !!",HttpStatus.FOUND);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


	public ResponseEntity<List<Admin>> getAllAdminByName(String name) {
		try {
			return new ResponseEntity(adminRepo.findByName(name),HttpStatus.FOUND);
		}catch (Exception e) {
			return new ResponseEntity("Request Got Failed: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
}
