package com.qa.saul.josh.springboot.vetProject.vetProjectApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.exception.ResourceNotFoundException;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.OwnerModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.OwnerRepository;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.PetRepository;



@RestController
public class OwnerController {
	
	@Autowired
	OwnerRepository ownerRepository;
	
	//Method to create a owner
	@PostMapping("/createOwner")
	public OwnerModel createOwner(@Valid @RequestBody OwnerModel owner) {
		return ownerRepository.save(owner);
	}
			
	//Method to get all owners
	@GetMapping("/getOwners")
	public Page<OwnerModel> getAllOwners(Pageable pageable){
		return ownerRepository.findAll(pageable);	
	}
	
	
	//Method to update a owner
	@PutMapping("/updateOwner/{owner_id}")
	public OwnerModel updateOwner(@PathVariable Long owner_id @Valid @RequestBody OwnerModel ownerRequest) {
		

		
	}
	
	
	//Method to remove a owner
	@DeleteMapping("/deleteOwner/{owner_id}")
	public ResponseEntity<?> deleteOwner(@PathVariable(value = "owner_id") Long owner_id){
		OwnerModel mSDM = Repository.findById(owner_id).orElseThrow(()->new ResourceNotFoundException("Owner","owner_id",owner_id));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
