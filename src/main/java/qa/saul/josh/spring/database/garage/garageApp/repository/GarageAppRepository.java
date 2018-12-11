package qa.saul.josh.spring.database.garage.garageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.saul.josh.spring.database.garage.garageApp.model.GarageAppModel;

@Repository
public interface GarageAppRepository extends JpaRepository<GarageAppModel, Long>{

}
