package com.jas.digitalgourmet.controller.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtCredentials implements Serializable {
	private static final long serialVersionUID = -9006590092525363686L;
	private String userName;
	private String password;

	public JwtCredentials() {
	}

	public JwtCredentials(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@JsonProperty("username")
	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtCredentials{" + "username='" + userName + '\'' + ", password='" + password + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		JwtCredentials that = (JwtCredentials) o;
		return Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, password);
	}
}
