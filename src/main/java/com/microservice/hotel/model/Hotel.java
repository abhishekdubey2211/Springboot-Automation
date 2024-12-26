package com.microservice.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="ms_hotel")
public class Hotel {
	@Id
	private String hotelId;
	private String name;
	private String location; // in future take full address
	private String about;
	
	@JsonIgnore
	private int active;
	@JsonIgnore
	private int isdelete;
	
}
