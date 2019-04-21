package com.jas.digitalgourmet.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "isActive" })
public abstract class DataTransferObjectLogicalDelete extends DataTransferObject{
	protected Boolean isActive = Boolean.TRUE;

	@JsonProperty("isActive")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
