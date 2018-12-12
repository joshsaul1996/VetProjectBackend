package qa.saul.josh.spring.database.garage.garageApp.model;
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
public class GarageAppModel implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idvehicle;
	
	@NotBlank
	private String vehiclereg;
	
	@NotBlank
	private String vehicletype;
	
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

	public Long getIdvehicle() {
		return idvehicle;
	}

	public void setIdvehicle(Long idvehicle) {
		this.idvehicle = idvehicle;
	}

	public String getVehiclereg() {
		return vehiclereg;
	}

	public void setVehiclereg(String vehiclereg) {
		this.vehiclereg = vehiclereg;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
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
	
	