package com.amsidh.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	private Integer vehicleId;
	private String vehicleName;
    
	@ManyToOne
	private UserDetails userDetail;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Integer vehicleId, String vehicleName) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}

	
}
