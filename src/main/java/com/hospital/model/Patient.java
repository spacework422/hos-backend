package com.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Patient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
	
	@Id
	@GeneratedValue
	private int id;
	
	    private String name;
	    private int age;
	    private int phoneno;
	    private String password;
	    private int patientweight;
	    private String patientbloodgroup;
	   
	    
} 
