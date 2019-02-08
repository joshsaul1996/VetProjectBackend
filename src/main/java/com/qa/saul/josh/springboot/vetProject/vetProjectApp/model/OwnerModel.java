package com.qa.saul.josh.springboot.vetProject.vetProjectApp.model;
import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "vehicles")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"creationDate","lastModified"},allowGetters = true)
public class OwnerModel implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idvehicle;
	
	@NotBlank
	private String vehicleReg;
	
	@NotBlank
	private String vehicleType;
	
	@NotBlank
	private String manufacturer;
	
	private String model;
	
	private String colour;
	
	@Column(nullable = true, updatable = false)
	@CreationTimestamp
	@CreatedDate
	private Date creationDate;
	
	@Column(nullable = true)
	@UpdateTimestamp
	@LastModifiedDate
	private Date lastModified;
	
	public OwnerModel(String vehicleReg, String vehicleType,String manufacturer, String model, String colour) {
		this.vehicleReg = vehicleReg;
		this.vehicleType = vehicleType;
		this.manufacturer = manufacturer;
		this.model = model;
		this.colour = colour;
	}
	  
	public OwnerModel() {
		
	}

	public Long getIdvehicle() {
		return idvehicle;
	}

	public void setIdvehicle(Long idVehicle) {
		this.idvehicle = idVehicle;
	}

	public String getVehiclereg() {
		return vehicleReg;
	}

	public void setVehiclereg(String vehicleReg) {
		this.vehicleReg = vehicleReg;
	}

	public String getVehicletype() {
		return vehicleType;
	}

	public void setVehicletype(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}


	
	
}
	
	