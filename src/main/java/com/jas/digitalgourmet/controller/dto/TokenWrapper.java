package com.jas.digitalgourmet.controller.dto;

import java.io.Serializable;

public class TokenWrapper implements Serializable {

    private String token;

    public TokenWrapper(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
