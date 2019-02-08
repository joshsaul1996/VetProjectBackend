package com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.OwnerModel;

@Repository
public interface GarageAppRepository extends JpaRepository<OwnerModel, Long>{
	
	List<OwnerModel> findByVehicleType(String vehicleType);
	List<OwnerModel> findByManufacturer(String manufacturer);
	List<OwnerModel> findByModel(String model);
	List<OwnerModel> findByColour(String colour);

}
