package com.jas.digitalgourmet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_ADDRESS")
public class Address extends PersistentObjectLogicalDelete {
	private String province;
	private String location;
	private String district;
	private Integer postalCode;
	private String street;
	private Integer number;
	private Boolean isDepartment = Boolean.FALSE;
	private Integer floor;
	private String department;
	private Boolean isDefault;
	private Person person;

	@Column(name = "PROVINCE", nullable = true)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "DISTRICT", nullable = true)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "LOCATION", nullable = true)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "POSTAL_CODE", nullable = true)
	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
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

	@Column(name = "IS_DEPARTMENT", nullable = false)
	public Boolean getIsDepartment() {
		return isDepartment;
	}

	public void setIsDepartment(Boolean isDepartment) {
		this.isDepartment = isDepartment;
	}

	@Column(name = "FLOOR", unique = false)
	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "DEPARTMENT", unique = false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "IS_DEFAULT", unique = false)
	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
