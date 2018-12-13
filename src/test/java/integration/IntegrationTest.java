package integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import qa.saul.josh.spring.database.garage.garageApp.GarageAppApplication;
import qa.saul.josh.spring.database.garage.garageApp.model.GarageAppModel;
import qa.saul.josh.spring.database.garage.garageApp.repository.GarageAppRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GarageAppApplication.class})
@AutoConfigureMockMvc
public class IntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private GarageAppRepository repository;
	
	@Before
	public void clearDB() {
		repository.deleteAll();
	}
	
	
	@Test
	public void findingAndRetrievingVehicleFromDatabase() throws Exception{
			repository.save(new GarageAppModel("AK18 VVN", "Car", "Audi", "A1", "Black"));
			mvc.perform(get("/api/vehicle").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].vehiclereg", is("AK18 VVN")));	
	}

	@Test
	public void addVehicleToDatabaseTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle")
				.contentType(MediaType.APPLICATION_JSON).content("{\"vehiclereg\" : \"HR89 2DH\",\"vehicletype\" : \"Car\",\"manufacturer\": \"Mercedes\",\"model\" : \"A-Class\",\"colour\" : \"Red\"}")).andExpect(status().isOk()).andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.vehiclereg", is("HR89 2DH")));
	}
	
	@Test
	public void updateVehicle() throws Exception{
		GarageAppModel testVehicle = new GarageAppModel("RE59 5TH", "Car", "BMW", "M3", "Black");
		repository.save(testVehicle);
		mvc.perform(MockMvcRequestBuilders.put("/api/vehicle/" + testVehicle.getIdvehicle())
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"vehiclereg\" : \"V10 MNT\",\"vehicletype\" : \"Car\",\"manufacturer\": \"BMW\",\"model\" : \"M3\",\"colour\" : \"Blue\"}"))
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.model", is("M3")));
		 
	}
	
	
	@Test
	public void deletingVehicleByID() throws Exception{
		GarageAppModel testVehicle = new GarageAppModel("RM15 0AS", "Van", "Citreon", "Berlingo", "White");
			repository.save(testVehicle);
			mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/" + testVehicle.getIdvehicle())
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			
			mvc.perform(delete("/api/vehicle/" + testVehicle.getIdvehicle())
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void deletingVehiclesByType() throws Exception{
		GarageAppModel testVehicle = new GarageAppModel("RM15 0AS", "Van", "Citreon", "Berlingo", "White");
		repository.save(testVehicle);
		mvc.perform(MockMvcRequestBuilders.delete("/api/vehicletype/" + testVehicle.getVehicletype())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void deletingVehicles() throws Exception{
		repository.save(new GarageAppModel("KL56 4RT", "Motorcycle", "Honda", "Z1", "Blue"));
			mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	 
	
}
