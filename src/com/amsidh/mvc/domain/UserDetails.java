package com.amsidh.mvc.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {

	@Id
	private Integer userId;
	private String userName;
    /*
	@JoinTable(name = "USER_VEHICLE", joinColumns = { @JoinColumn(name = "USERID") }, inverseJoinColumns = {
			@JoinColumn(name = "VEHICLEID") })*/
	@OneToMany(cascade=CascadeType.ALL, mappedBy="userDetail")
	private Collection<Vehicle> vehicle = new ArrayList<>();

	public UserDetails() {
		super();
	}

	public UserDetails(String userName) {
		super();
		this.userName = userName;
	}

	public UserDetails(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
