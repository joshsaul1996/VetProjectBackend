package qa.saul.josh.spring.database.garage.garageApp.controller;

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

import qa.saul.josh.spring.database.garage.garageApp.exception.ResourceNotFoundException;
import qa.saul.josh.spring.database.garage.garageApp.model.GarageAppModel;
import qa.saul.josh.spring.database.garage.garageApp.repository.GarageAppRepository;



@RestController
@RequestMapping("/api")
public class GarageAppController {
	
	@Autowired
	GarageAppRepository Repository;
	
	
	//Method to create a vehicle
	@PostMapping("/vehicle")
	public GarageAppModel createVehicle(@Valid @RequestBody GarageAppModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get a vehicle
	@GetMapping("vehicle/{idvehicle}")
	public GarageAppModel getVehiclebyID(@PathVariable(value = "idvehicle")Long vehicleID) {
		return Repository.findById(vehicleID).orElseThrow(()->new ResourceNotFoundException("GarageAppModel", "idvehicle",vehicleID));
		}
	
	//Method to get all vehicles
	@GetMapping("/vehicle")
	public List<GarageAppModel> getAllVehicles(){
		return Repository.findAll();
	}
	
	
	//Method to update a vehicle
	@PutMapping("/vehicle/{idvehicle}")
	public GarageAppModel updateVehicle(@PathVariable(value = "idvehicle") Long vehicleID,
			@Valid @RequestBody GarageAppModel vehicleDetails) {
		GarageAppModel mSDM = Repository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("Vehicle","idvehicle",vehicleID));
		
		mSDM.setVehiclereg(vehicleDetails.getVehiclereg());
		mSDM.setManufacturer(vehicleDetails.getManufacturer());
		mSDM.setModel(vehicleDetails.getModel());
		mSDM.setColour(vehicleDetails.getColour());
		
		
		GarageAppModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a vehicle
	@DeleteMapping("/vehicle/{idvehicle}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "idvehicle") Long vehicleID){
		GarageAppModel mSDM = Repository.findById(vehicleID).orElseThrow(()->new ResourceNotFoundException("Vehicle","idvehicle",vehicleID));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	
	

}
