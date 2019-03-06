package com.qa.saul.josh.springboot.vetProject.vetProjectApp.model;
import java.io.Serializable;



import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pet")
@EntityListeners(AuditingEntityListener.class)
public class PetModel {
	
	
	@Id
	@Column(name = "pet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pet_id;
	
	private String name;
	
	private String microchip_number;
	
	private String species;
	
	private String breed;
	
	private int age;
	
	private String medical_history;
	
	private String prescriptions;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "owner_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private OwnerModel owner;

	public Long getPet_id() {
		return pet_id;
	}

	public void setPet_id(Long pet_id) {
		this.pet_id = pet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMicrochip_number() {
		return microchip_number;
	}

	public void setMicrochip_number(String microchip_number) {
		this.microchip_number = microchip_number;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(String medical_history) {
		this.medical_history = medical_history;
	}

	public String getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}

	public OwnerModel getOwner() {
		return owner;
	}
	public PetModel() {
		
	}
	

	public PetModel( String name, String microchip_number, String species, String breed, int age,
			String medical_history, String prescriptions, OwnerModel owner) {
	
		this.name = name;
		this.microchip_number = microchip_number;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.medical_history = medical_history;
		this.prescriptions = prescriptions;
		this.owner = owner;
	}

	public void setOwner(OwnerModel owner) {
		this.owner = owner;
	}

	
	
}
	
	