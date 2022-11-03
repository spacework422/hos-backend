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

import com.hospital.model.Pharma;
import com.hospital.repository.PharmaRepository;
import com.hospital.exception.ResourceNotFoundException; 
  
@RestController
@RequestMapping("/pharmacontroller")
@CrossOrigin
public class PharmaController {
	
	@Autowired
	private PharmaRepository prepo;
	
	//Get - 
	//http://localhost:7075/hospital/pharmacontroller/getpharma
	@GetMapping("/getpharma")
	public List<Pharma> getAllProducts() {
		return prepo.findAll();  
	} 
	
	//POST - 
	//http://localhost:7075/hospital/pharmacontroller/pharmaregister
	@PostMapping("/pharmaregister")
    public Pharma saveProduct(@Validated @RequestBody Pharma pharma) {
     return prepo.save(pharma);
                    
	}
	
	//Get By ID - 
	//http://localhost:7075/hospital/pharmacontroller/getbyid/{id}
	@GetMapping("/getbyid/{id}")
    public ResponseEntity<Pharma> getProductById(@PathVariable(value="id") Integer pId)
    		throws ResourceNotFoundException
    		{
		Pharma pharma =prepo.findById(pId).  //findById()  method is predefined in jpa in build
    			         orElseThrow(() -> new ResourceNotFoundException
    			          ("Pharma  Not Found for this Id: "+ String.valueOf(pId)));
    	             
    	             return ResponseEntity.ok().body(pharma);     
    		}
	
	//Post verify user id
	//http://localhost:7075/hospital/pharmacontroller/pharmalogin
	   @PostMapping("/pharmalogin")
	    public Boolean loginUser(@Validated @RequestBody Pharma pharma) 
	    {
	        Boolean a=false;;
	        String name=pharma.getName();
	        String password=pharma.getPassword();
	        Pharma b = prepo.findByName(name);
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



