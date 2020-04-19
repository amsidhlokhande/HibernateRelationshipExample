package com.amsidh.mvc.domain.many.to.many;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	private Integer personId;
	private String personName;
	private String description;
	private Date dateOfBirth;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Address> addresses = new ArrayList<>();

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Integer personId, String personName, String description, Date dateOfBirth) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.description = description;
		this.dateOfBirth = dateOfBirth;
	}

	public Person(String personName, String description, Date dateOfBirth) {
		super();
		this.personName = personName;
		this.description = description;
		this.dateOfBirth = dateOfBirth;
	}

	
}
