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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "appointment")
@EntityListeners(AuditingEntityListener.class)
public class AppointmentModel implements Serializable {
	
	
	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointment_id;
	
	@NotBlank
	private String reason;
	
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private Date date;
	
	@NotBlank
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vet_vn_id", nullable = false)
	private VetVNModel vetVN;
	
	  
	public AppointmentModel() {
		
	}


	public AppointmentModel(@NotBlank String reason, @NotBlank Date date, @NotBlank VetVNModel vetVN,
			@NotBlank PetModel pet) {
		this.reason = reason;
		this.date = date;
		this.vetVN = vetVN;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public VetVNModel getVetVN() {
		return vetVN;
	}


	public void setVetVN(VetVNModel vetVN) {
		this.vetVN = vetVN;
	}
	
}
	
	