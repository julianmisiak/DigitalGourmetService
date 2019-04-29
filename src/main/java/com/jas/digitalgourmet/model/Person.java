package com.jas.digitalgourmet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Person extends PersistentObjectLogicalDelete{
	private String name;
	private String surname;
	private Integer idCard;
	private Gender gender;
	private String email;
	private List<Address> addresses = new ArrayList<Address>();
	
	@Column(name = "NAME", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "SURNAME", nullable = true)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "ID_CARD", nullable = true)
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	
	@Column(name = "GENDER", nullable = true)
	@Enumerated(EnumType.ORDINAL) 
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(name = "EMAIL", nullable = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	

}
