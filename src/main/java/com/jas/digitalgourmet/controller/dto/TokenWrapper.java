package com.jas.digitalgourmet.controller.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenWrapper implements Serializable {
	private static final long serialVersionUID = -619295101061917399L;
	private String token;

    public TokenWrapper(String token) {
        this.token = token;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
