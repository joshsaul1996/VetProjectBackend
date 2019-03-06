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
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.AppointmentModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.OwnerModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.AppointmentRepository;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.OwnerRepository;



@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository Repository;
	
	
	//Method to create a appointment
	@PostMapping("/createAppointment")
	public AppointmentModel createAppointment(@Valid @RequestBody AppointmentModel mSDM) {
		return Repository.save(mSDM);
	}
	
	
	//Method to get a appointment
	@GetMapping("getAppointment/{appointment_id}")
	public AppointmentModel getAppointment(@PathVariable(value = "appointment_id")Long appointment_id) {
		return Repository.findById(appointment_id).orElseThrow(()->new ResourceNotFoundException("AppointmentModel", "appointment_id",appointment_id));
	}
	
	
	//Method to get all appointments
	@GetMapping("/appointments")
	public List<AppointmentModel> getAppointments(){
		return Repository.findAll();
	}
	
	
	//Method to update a appointment
	@PutMapping("/updateAppointment/{appointment_id}")
	public AppointmentModel updateAppointment(@PathVariable(value = "appointment_id") Long appointment_id,
			@Valid @RequestBody AppointmentModel appointmentDetails) {
		AppointmentModel mSDM = Repository.findById(appointment_id).orElseThrow(()-> new ResourceNotFoundException("Appointment","appointment_id",appointment_id));
		
		mSDM.setReason(appointmentDetails.getReason());
		mSDM.setDate(appointmentDetails.getDate());
		mSDM.setVetVN(appointmentDetails.getVetVN());

		
		
		AppointmentModel updateData = Repository.save(mSDM);
		return updateData;
		
	}
	
	
	//Method to remove a appointment
	@DeleteMapping("/deleteAppointment/{appointment_id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable(value = "appointment_id") Long appointment_id){
		AppointmentModel mSDM = Repository.findById(appointment_id).orElseThrow(()->new ResourceNotFoundException("Appointment","appointment_id",appointment_id));
		
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
