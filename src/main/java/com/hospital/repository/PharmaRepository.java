package com.hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Pharma;


@Repository
public interface PharmaRepository extends JpaRepository<Pharma, Integer>{
	
	public Pharma findByName(String name);

}