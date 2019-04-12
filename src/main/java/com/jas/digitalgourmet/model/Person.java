package com.jas.digitalgourmet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Person extends PersistentObject{
	private String name;
	private String surname;
	private Integer idCard;
	private Gender gender;
	private String mail;
	private List<Address> addresses = new ArrayList<Address>();
	
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "SURNAME", nullable = false)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "ID_CARD", nullable = false)
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	
	@Column(name = "GENDER", nullable = false)
	@Enumerated(EnumType.ORDINAL) 
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		gender = this.gender;
	}
	
	@Column(name = "MAIL", nullable = false)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@OneToMany(mappedBy = "person")
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	

}
