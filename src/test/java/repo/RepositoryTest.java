package repo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.saul.josh.springboot.vetProject.vetProjectApp.VetProjectApplication;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.OwnerModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.GarageAppRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {VetProjectApplication.class})
//@SpringBootTest(classes = { GarageAppApplication.class})
@DataJpaTest 
public class RepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private GarageAppRepository myRepo;
	
	
	@Test
	public void retrieveByIdTest() {
		OwnerModel model = new OwnerModel("HJ67 9YT", "Car", "Audi", "RS6", "Grey");
		entityManager.persist(model);
		entityManager.flush();
		assertTrue(myRepo.findById(model.getIdvehicle()).isPresent());
	}
	 
	@Test
	public void retrieveByTypeTest() {
		OwnerModel model = new OwnerModel("HJ67 9YT", "Car", "Audi", "RS6", "Grey");
		entityManager.persist(model);
		entityManager.flush();
		assertTrue(myRepo.findByVehicleType(model.getVehicletype()).stream().findAny().isPresent());
	}
	
	
	@Test
	public void retrieveByManufacturerTest() {
		OwnerModel model = new OwnerModel("HJ67 9YT", "Car", "Audi", "RS6", "Grey");
		entityManager.persist(model);
		entityManager.flush();
		assertTrue(myRepo.findByManufacturer(model.getManufacturer()).stream().findAny().isPresent());
	}
	
	
	
	@Test
	public void retrieveByModelTest() {
		OwnerModel model = new OwnerModel("HJ67 9YT", "Car", "Audi", "RS6", "Grey");
		entityManager.persist(model);
		entityManager.flush();
		assertTrue(myRepo.findByModel(model.getModel()).stream().findAny().isPresent());
	}
	
	@Test
	public void retrieveByColourTest() {
		OwnerModel model = new OwnerModel("HJ67 9YT", "Car", "Audi", "RS6", "Grey");
		entityManager.persist(model);
		entityManager.flush();
		assertTrue(myRepo.findByColour(model.getColour()).stream().findAny().isPresent());
	}

}
