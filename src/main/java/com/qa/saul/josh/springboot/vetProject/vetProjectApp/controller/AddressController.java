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
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.AddressModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.AddressRepository;



@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	AddressRepository Repository;
	
	
	//Method to create address
	@PostMapping("/createAddress")
	public AddressModel createAddress(@Valid @RequestBody AddressModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get address
	@GetMapping("/getAddress/{address_id}")
	public AddressModel getAddress(@PathVariable(value = "address_id")Long address_id) {
		return Repository.findById(address_id).orElseThrow(()->new ResourceNotFoundException("AddressModel", "address_id",address_id));
	}
	
		
	//Method to get all address
	@GetMapping("/getAddresses")
	public List<AddressModel> getAllAddresses(){
		return Repository.findAll();
	}
	
	
	//Method to update a address
	@PutMapping("/updateAddress/{address_id}")
	public AddressModel updateAddress(@PathVariable(value = "address_id") Long address_id,
			@Valid @RequestBody AddressModel addressDetails) {
		AddressModel mSDM = Repository.findById(address_id).orElseThrow(()-> new ResourceNotFoundException("Address","address_id",address_id));
		
		mSDM.setHouse_number(addressDetails.getHouse_number());
		mSDM.setAddress_line_1(addressDetails.getAddress_line_1());
		mSDM.setAddress_line_2(addressDetails.getAddress_line_2());
		mSDM.setAddress_line_3(addressDetails.getAddress_line_3());
		mSDM.setCity(addressDetails.getCity());
		mSDM.setCounty(addressDetails.getCounty());
		mSDM.setPostcode(addressDetails.getPostcode());
		mSDM.setCountry(addressDetails.getCountry());
		
		
		AddressModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a address
	@DeleteMapping("/deleteAddress/{address_id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "address_id") Long address_id){
		AddressModel mSDM = Repository.findById(address_id).orElseThrow(()->new ResourceNotFoundException("Address","address_id",address_id));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
