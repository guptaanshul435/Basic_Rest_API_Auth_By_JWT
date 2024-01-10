package com.adoptnet.admin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptnet.admin.modles.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
 
	public List<Admin> findByName(String name);
}
