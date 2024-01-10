package com.adoptnet.admin.modles;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "dep_id", 
scope     = Long.class)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dep_id;
	
	@Column(name = "depName")
	private String dep_name;
	private String dep_course;
	
	
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Student> student=new ArrayList<>();
	
	
	
}
