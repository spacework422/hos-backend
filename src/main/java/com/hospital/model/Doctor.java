package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Doctor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {
	
	@Id
	@GeneratedValue
	private int id;
	
	    private String name;
	    private String email;
	    private int age;
	    private int phoneno;
	    private String password;
	   
	    
} 
