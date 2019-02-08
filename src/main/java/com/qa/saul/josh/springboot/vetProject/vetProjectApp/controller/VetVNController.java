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
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.OwnerModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.GarageAppRepository;



@RestController
@RequestMapping("/api")
public class VetVNController {
	
	@Autowired
	GarageAppRepository Repository;
	
	
	//Method to create a vehicle
	@PostMapping("/vehicle")
	public OwnerModel createVehicle(@Valid @RequestBody OwnerModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get a vehicle
	@GetMapping("vehicleid/{idvehicle}")
	public OwnerModel getVehiclebyID(@PathVariable(value = "idvehicle")Long vehicleID) {
		return Repository.findById(vehicleID).orElseThrow(()->new ResourceNotFoundException("GarageAppModel", "idvehicle",vehicleID));
	}
	
	// Method get vehicles by Type
	@GetMapping("vehicletype/{vehicletype}")
	public List<OwnerModel> getVehicleByType(@PathVariable(value = "vehicletype")String vehicletype) {
		return Repository.findByVehicleType(vehicletype);
	}
	
	
	// Method get vehicles by Manufacturer
	@GetMapping("vehiclemanufacturer/{manufacturer}")
	public List<OwnerModel> getVehicleByManufacturer(@PathVariable(value = "manufacturer")String manufacturer) {
		return Repository.findByManufacturer(manufacturer);
	}
	
		
		
	// Method get vehicles by Model
	@GetMapping("vehiclemodel/{model}")
	public List<OwnerModel> getVehicleByModel(@PathVariable(value = "model")String model) {
		return Repository.findByModel(model);
	}	
		
		
		
	// Method get vehicles by Colour
	@GetMapping("vehiclecolour/{colour}")
	public List<OwnerModel> getVehicleByColour(@PathVariable(value = "colour")String colour) {
		return Repository.findByColour(colour);
	}	
		
		
		
		
	//Method to get all vehicles
	@GetMapping("/vehicle")
	public List<OwnerModel> getAllVehicles(){
		return Repository.findAll();
	}
	
	
	//Method to update a vehicle
	@PutMapping("/vehicle/{idvehicle}")
	public OwnerModel updateVehicle(@PathVariable(value = "idvehicle") Long vehicleID,
			@Valid @RequestBody OwnerModel vehicleDetails) {
		OwnerModel mSDM = Repository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("Vehicle","idvehicle",vehicleID));
		
		mSDM.setVehiclereg(vehicleDetails.getVehiclereg());
		mSDM.setVehicletype(vehicleDetails.getVehicletype());
		mSDM.setManufacturer(vehicleDetails.getManufacturer());
		mSDM.setModel(vehicleDetails.getModel());
		mSDM.setColour(vehicleDetails.getColour());
		
		
		OwnerModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a vehicle
	@DeleteMapping("/vehicle/{idvehicle}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "idvehicle") Long vehicleID){
		OwnerModel mSDM = Repository.findById(vehicleID).orElseThrow(()->new ResourceNotFoundException("Vehicle","idvehicle",vehicleID));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	// Method delete vehicles by Type
	@DeleteMapping("/vehicletype/{vehicletype}")
	public ResponseEntity<?> deleteVehicleByType(@PathVariable(value = "vehicletype") String vehicleType){
		List<OwnerModel> mSDM = Repository.findByVehicleType(vehicleType);
		 
		Repository.deleteAll(mSDM);
		return ResponseEntity.ok().build();
	}
	
	//Method to remove all vehicles from the database
	@DeleteMapping("/vehicle")
	public ResponseEntity<?> deleteAllVehicles(){
		Repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
