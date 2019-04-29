package com.jas.digitalgourmet.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "province", "district", "location", "postalCode", "street", "number", "isDepartment", "department"})
public class AddressDTO extends DataTransferObjectLogicalDelete {
	private String province;
	private String district;
	private String location;
	private Integer postalCode;
	private String street;
	private Integer number;
	private Boolean isDepartment = Boolean.FALSE;
	private String department;
	private Boolean isDefault = Boolean.FALSE;
	
	@JsonProperty("province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@JsonProperty("district")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonProperty("postalCode")
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
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
	
	@JsonProperty("isDepartment")
	public Boolean getIsDepartment() {
		return isDepartment;
	}
	public void setIsDepartment(Boolean isDepartment) {
		this.isDepartment = isDepartment;
	}
	
	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@JsonProperty("isDefault")
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	

}
