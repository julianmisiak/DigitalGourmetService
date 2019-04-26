package com.jas.digitalgourmet.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "province", "location", "postal_code", "street", "number", "isDepartment", "floor", "department"})
public class AddressDTO extends DataTransferObjectLogicalDelete {
	private String province;
	private String location;
	private String postalCode;
	private String street;
	private Integer number;
	private Boolean isDepartment = Boolean.FALSE;
	private Integer floor;
	private String department;
	
	@JsonProperty("province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonProperty("postal_code")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@JsonProperty("street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@JsonProperty("is_department")
	public Boolean getIsDepartment() {
		return isDepartment;
	}
	public void setIsDepartment(Boolean isDepartment) {
		this.isDepartment = isDepartment;
	}
	
	@JsonProperty("floor")
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
