package com.jas.digitalgourmet.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jas.digitalgourmet.model.AccessResource;

@JsonPropertyOrder({ "name", "Description", "accessResources" })
public class RoleDTO extends DataTransferObjectLogicalDelete{
	private String name;
	private String description;
	private List<AccessResourceDTO> accessResources;

	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("accessResources")
	public List<AccessResourceDTO> getAccessResources() {
		return accessResources;
	}
	public void setAccessResources(List<AccessResourceDTO> accessResources) {
		this.accessResources = accessResources;
	}
	
}
