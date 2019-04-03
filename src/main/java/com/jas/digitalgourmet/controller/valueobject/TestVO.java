package com.jas.digitalgourmet.controller.valueobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "createDate", "modificationDate" })
public class TestVO {
	private Date createDate;
	private Date modificationDate;
	
	@JsonProperty("createDate")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonProperty("modificationDate")
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
}
