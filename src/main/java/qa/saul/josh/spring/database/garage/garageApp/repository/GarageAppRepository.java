package qa.saul.josh.spring.database.garage.garageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.saul.josh.spring.database.garage.garageApp.model.GarageAppModel;

@Repository
public interface GarageAppRepository extends JpaRepository<GarageAppModel, Long>{
	
	List<GarageAppModel> findByVehicleType(String vehicleType);
	List<GarageAppModel> findByManufacturer(String manufacturer);
	List<GarageAppModel> findByModel(String model);
	List<GarageAppModel> findByColour(String colour);

}
