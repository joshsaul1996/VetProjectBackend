package com.qa.saul.josh.springboot.vetProject.vetProjectApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.saul.josh.springboot.vetProject.vetProjectApp.exception.ResourceNotFoundException;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.VetVNModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.VetVNRepository;



@RestController
@RequestMapping("/api")
public class VetVNController {
	
	@Autowired
	VetVNRepository Repository;
	
	
	//Method to create a VetVN
	@PostMapping("/createVetVN")
	public VetVNModel createVetVN(@Valid @RequestBody VetVNModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get a  VetVN
	@GetMapping("VetVN/{vid}")
	public VetVNModel getVetVN(@PathVariable(value = "vid")Long vid) {
		return Repository.findById(vid).orElseThrow(()->new ResourceNotFoundException("VetVNModel", "vid",vid));
	}
	
	//Method to get all  VetVN
	@GetMapping("/getAllVetVN")
	public List<VetVNModel> getAllVetVN(){
		return Repository.findAll();
	}
	
	
	//Method to update a  VetVN
	@PutMapping("/updateVetVN/{vid}")
	public VetVNModel updateVetVN(@PathVariable(value = "vid") Long vid,
			@Valid @RequestBody VetVNModel vetVNDetails) {
		VetVNModel mSDM = Repository.findById(vid).orElseThrow(()-> new ResourceNotFoundException("VetVN","vid",vid));
		
		mSDM.setTitle(vetVNDetails.getTitle());
		mSDM.setFirst_name(vetVNDetails.getFirst_name());
		mSDM.setLast_name(vetVNDetails.getLast_name());
		mSDM.setRole(vetVNDetails.getRole());
		mSDM.setSpecialities(vetVNDetails.getSpecialities());
		
		
		VetVNModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a  VetVN
	@DeleteMapping("/deleteVetVN/{vid}")
	public ResponseEntity<?> deleteVetVN(@PathVariable(value = "vid") Long vid){
		VetVNModel mSDM = Repository.findById(vid).orElseThrow(()->new ResourceNotFoundException("VetVN","vid",vid));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
