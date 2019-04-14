package com.jas.digitalgourmet.controller.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "oid", "createTimestamp", "modificationTimestamp", "creationUser", "modificationUser" })
public abstract class DataTransferObject {
	protected Long oid;
	protected Calendar createTimestamp;
	protected Calendar modificationTimestamp;
	protected String creationUser;
	protected String modificationUser;
	protected Long pepe;


	@JsonProperty("createTimestamp")
	public Calendar getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Calendar createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@JsonProperty("modificationTimestamp")
	public Calendar getModificationTimestamp() {
		return modificationTimestamp;
	}

	public void setModificationTimestamp(Calendar modificationTimestamp) {
		this.modificationTimestamp = modificationTimestamp;
	}

	@JsonProperty("creationUser")
	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	@JsonProperty("modificationUser")
	public String getModificationUser() {
		return modificationUser;
	}

	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}

	@JsonProperty("oid")
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	@JsonProperty("pepe")
	public Long getPepe() {
		return pepe;
	}

	public void setPepe(Long pepe) {
		this.pepe = pepe;
	}

	
	
	
}
