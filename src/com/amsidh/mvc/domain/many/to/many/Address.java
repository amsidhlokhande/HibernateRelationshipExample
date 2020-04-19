package com.amsidh.mvc.domain.many.to.many;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Address {

	@Id
	private Integer addressId;
	private String state;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="addresses")
	private Collection<Person> persons = new ArrayList<>();

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId, String state) {
		super();
		this.addressId = addressId;
		this.state = state;
	}

	public Address(String state) {
		super();
		this.state = state;
	}

}
