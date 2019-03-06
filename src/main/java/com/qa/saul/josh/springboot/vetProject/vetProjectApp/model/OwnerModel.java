package com.qa.saul.josh.springboot.vetProject.vetProjectApp.model;
import java.io.Serializable;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.OwnerRepository;
import com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository.PetRepository;



@Entity
@Table(name = "owner")
@EntityListeners(AuditingEntityListener.class)
public class OwnerModel implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
	private Long owner_id;
	
	private String first_name;
	
	private String last_name;
	
	@Email
	private String email;
	
	private String landline_number;
	
	private String mobile_number;
	
	private String address_id;


	public OwnerModel(String first_name, String last_name, @Email String email, String landline_number,
			String mobile_number,String address_id, Set<PetModel> pets) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.landline_number = landline_number;
		this.mobile_number = mobile_number;
		this.address_id = address_id;
	}



	public OwnerModel() {
		
	}



	public Long getOwner_id() {
		return owner_id;
	}



	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLandline_number() {
		return landline_number;
	}



	public void setLandline_number(String landline_number) {
		this.landline_number = landline_number;
	}



	public String getMobile_number() {
		return mobile_number;
	}



	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}


	public String getAddress_id() {
		return address_id;
	}



	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	
	

	
}
	
	