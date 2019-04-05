package com.jas.digitalgourmet.controller.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "OID", "createTimestamp", "modificationTimestamp", "creationUser", "modificationUser" })
public abstract class DataTransferObject {
	protected Long OID;
	protected Calendar createTimestamp;
	protected Calendar modificationTimestamp;
	protected String creationUser;
	protected String modificationUser;
	
	@JsonProperty("OID")
	public Long getOID() {
		return OID;
	}
	public void setOID(Long OID) {
		OID = this.OID;
	}
	
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
	
}
