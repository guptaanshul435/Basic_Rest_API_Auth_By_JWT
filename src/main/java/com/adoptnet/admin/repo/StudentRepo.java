package com.adoptnet.admin.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptnet.admin.modles.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	
}
