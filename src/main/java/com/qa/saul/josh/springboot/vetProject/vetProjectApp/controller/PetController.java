package com.qa.saul.josh.springboot.vetProject.vetProjectApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.exception.ResourceNotFoundException;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.PetModel;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.OwnerRepository;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.PetRepository;

@RestController
public class PetController {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	
	//Method to create a pet
	@PostMapping("/owner/{owner_id}/createPet")
	public PetModel createComment(@PathVariable (value = "owner_id") Long owner_id, @Valid @RequestBody PetModel pet) {
		return ownerRepository.findById(owner_id).map(repo ->{
			pet.setOwner(repo);
			return petRepository.save(pet);
		}).orElseThrow(() -> new ResourceNotFoundException("Owner", "id", pet));
	}
	
	
	
	
	
	//Method to update a pet
	@PutMapping("/owner/{owner_id}/updatePet/{pet_id}")
	public PetModel updatePet(@PathVariable(value = "owner_id") Long owner_id, @PathVariable (value = "pet_id") Long pet_id, @Valid @RequestBody PetModel petRequest) {
		if(!ownerRepository.existsById(owner_id)) {
			throw new ResourceNotFoundException("Owner", "id", petRequest);
		}
		return petRepository.findById(pet_id).map(pet ->{
			pet.setName(petRequest.getName());
			pet.setMicrochip_number(petRequest.getMicrochip_number());
			pet.setSpecies(petRequest.getSpecies());
			pet.setBreed(petRequest.getBreed());
			pet.setAge(petRequest.getAge());
			pet.setMedical_history(petRequest.getMedical_history());
			pet.setPrescriptions(petRequest.getPrescriptions());
			return petRepository.save(pet);
			}).orElseThrow(() -> new ResourceNotFoundException("PetID", "id", petRequest));
	}
	
	
	//Method to remove a pet
	@DeleteMapping("/owner/{owner_id}/deletePet/{pet_id}")
	public ResponseEntity<?> deleteComment(@PathVariable(value = "owner_id") Long owner_id, @PathVariable (value = "pet_id") Long pet_id){
		if(!ownerRepository.existsById(owner_id)) {
			throw new ResourceNotFoundException("Owner", "id", owner_id);
		}
		return petRepository.findById(pet_id).map(pet -> {
			petRepository.delete(pet);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PetID", pet_id.toString(),null));	
	}
}
