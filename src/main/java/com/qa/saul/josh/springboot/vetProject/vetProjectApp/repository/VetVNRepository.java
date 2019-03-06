package com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.VetVNModel;



@Repository
public interface VetVNRepository extends JpaRepository<VetVNModel, Long>{
	

}
