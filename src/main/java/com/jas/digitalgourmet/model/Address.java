package com.jas.digitalgourmet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSON_ADDRESS")
public class Address extends PersistentObject{
	private String province;
	private String location;
	private String postalCode;
	private String street;
	private Integer number;
	private Boolean isDepartment = Boolean.FALSE;
	private Integer floor;
	private String department;
	private Person person;
	
	@Column(name = "PROVINCE", nullable = true)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name = "LOCATION", nullable = true)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "POSTAL_CODE", nullable = true)
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name = "STREET", nullable = true)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "NUMBER", nullable = true)
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Column(name = "IS_DEPARTMENT", nullable = true)
	public Boolean getIsDepartment() {
		return isDepartment;
	}
	public void setIsDepartment(Boolean isDepartment) {
		this.isDepartment = isDepartment;
	}
	
	@Column(name = "FLOOR", unique = true)
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
	@Column(name = "DEPARTMENT", unique = true)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
