package com.adoptnet.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptnet.admin.modles.Admin;
import com.adoptnet.admin.services.AdminService;

@RestController
@RequestMapping("admins")
public class AdminController {

	
	@Autowired
	AdminService adminService;
	
	
	@GetMapping("admin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable int id) {
		return (ResponseEntity)adminService.getDataById(id);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Admin>> getAllAdmins(){
		return adminService.geAllAdmins();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Admin>> getAllAdminsByName(@PathVariable String name){
		return adminService.getAllAdminByName(name);
		
	}
	
	@PostMapping("admin")
	public ResponseEntity<String> postAdmin(@RequestBody Admin admin) {
		
		return adminService.postData(admin);
	}
	
	@PutMapping("admin/{id}")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin,@PathVariable int id){
		
		return adminService.updateAdmin(admin,id);
	}
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> removeAdmin(@PathVariable int id){
		return adminService.removeAdmin(id);
		
	}
	
	
}
