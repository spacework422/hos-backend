package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;
import com.hospital.exception.ResourceNotFoundException; 
  
@RestController
@RequestMapping("/doctorcontroller")
@CrossOrigin
public class DoctorController {
	
	@Autowired
	private DoctorRepository drepo;
	
	//Get - 
	//http://localhost:7075/hospital/doctorcontroller/getdoctor
	@GetMapping("/getdoctor")
	public List<Doctor> getAllProducts() {
		return drepo.findAll(); 
	} 
	
	//POST - 
	//http://localhost:7075/hospital/doctorcontroller/doctorregister
	@PostMapping("/doctorregister")
    public Doctor saveProduct(@Validated @RequestBody Doctor doctor) {
     return drepo.save(doctor); 
                    
	}
	
	//Get By ID - 
	//http://localhost:7075/hospital/doctorcontroller/getbyid/{id}
	@GetMapping("/getbyid/{id}")
    public ResponseEntity<Doctor> getProductById(@PathVariable(value="id") Integer dId)
    		throws ResourceNotFoundException
    		{
		      Doctor doctor =drepo.findById(dId).  //findById()  method is predefined in jpa in build
    			         orElseThrow(() -> new ResourceNotFoundException
    			          ("doctor  Not Found for this Id: "+ String.valueOf(dId)));
    	             
    	             return ResponseEntity.ok().body(doctor);     
    		}
	
	//Post verify user id
	//http://localhost:7075/hospital/doctorcontroller/doctorlogin
	   @PostMapping("/doctorlogin")
	    public Boolean loginUser(@Validated @RequestBody Doctor doctor) 
	    {
	        Boolean a=false;;
	        String name=doctor.getName();
	        String password=doctor.getPassword();
	        Doctor b = drepo.findByName(name);
	        if(b==null) {
	        	return a;
	        }
	        if(name.equals(b.getName()) && password.equals(b.getPassword()))
	                {
	            a=true;
	           
	                }
	        return a;
	    }

} 


