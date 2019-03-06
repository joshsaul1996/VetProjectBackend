package com.qa.saul.josh.springboot.vetProject.vetProjectApp.model;
import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "vet_vn")
@EntityListeners(AuditingEntityListener.class)
public class VetVNModel implements Serializable {
	
	
	@Id
	@Column(name = "vid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vid;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String first_name;
	
	@NotBlank
	private String last_name;
	
	@NotBlank
	private String role;
	
	private String specialities;
	
	@OneToOne(fetch=FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "vetVN")
	private AppointmentModel appointmentModel;

	
	
	public VetVNModel(@NotBlank String title, @NotBlank String first_name, @NotBlank String last_name,
			@NotBlank String role, String specialities) {
		this.title = title;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
		this.specialities = specialities;

	}



	public VetVNModel(){
		
	}



	public Long getVid() {
		return vid;
	}



	public void setVid(Long vid) {
		this.vid = vid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getSpecialities() {
		return specialities;
	}



	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	
	
	
	


	
	
}
	
	