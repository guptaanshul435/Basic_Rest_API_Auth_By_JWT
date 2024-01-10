package com.adoptnet.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptnet.admin.modles.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
