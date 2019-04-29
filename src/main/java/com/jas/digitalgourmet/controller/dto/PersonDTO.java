package com.jas.digitalgourmet.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jas.digitalgourmet.model.Gender;

@JsonPropertyOrder({ "name", "surname", "idCard", "gender", "mail" })
public class PersonDTO extends DataTransferObjectLogicalDelete{
	private String name;
	private String surname;
	private Integer idCard;
	private Gender gender;
	private String email;
	private List<AddressDTO> addresses;
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("surname")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@JsonProperty("idCard")
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	
	@JsonProperty("gender")
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("addresses")
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	
	
	
	

}
