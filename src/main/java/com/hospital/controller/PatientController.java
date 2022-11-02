package com.hospital.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;

@RestController
@RequestMapping("/patientcontroller")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientRepository prepo;
	
	
	@GetMapping("/getpatient")
	public List<Patient> getAllProducts() {
		return prepo.findAll(); 
	} 
	
	//POST - http://localhost:7075/hospital/patientcontroller/patientregister
	@PostMapping("/patientregister")
    public Patient saveProduct(@Validated @RequestBody Patient patient) {
     return prepo.save(patient);
                    
	}

} 


