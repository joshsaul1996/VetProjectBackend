package com.qa.saul.josh.springboot.vetProject.vetProjectApp.model;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
public class AddressModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long address_id;
	
	
    private Integer house_number;
	
	
	private String address_line_1;
	
	
	private String address_line_2;
	
	
	private String address_line_3;
	
	
	private String city;
	
	
	private String county;
	
	
	private String postcode;
	
	
	private String country;
	
	  
	public AddressModel() {
		
	}


	public AddressModel( Integer house_number,  String address_line_1, String address_line_2,
			String address_line_3,  String city,  String county,  String postcode,
			 String country) {
		this.house_number = house_number;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.address_line_3 = address_line_3;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
		this.country = country;
	}


	public Long getAddressid() {
		return address_id;
	}


	public void setAddressid(Long address_id) {
		this.address_id = address_id;
	}


	public Integer getHouse_number() {
		return house_number;
	}


	public void setHouse_number(Integer house_number) {
		this.house_number = house_number;
	}


	public String getAddress_line_1() {
		return address_line_1;
	}


	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}


	public String getAddress_line_2() {
		return address_line_2;
	}


	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}


	public String getAddress_line_3() {
		return address_line_3;
	}


	public void setAddress_line_3(String address_line_3) {
		this.address_line_3 = address_line_3;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	
	
}
	
	