package com.jas.digitalgourmet.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;

public class DigitalGourmetAuthenticationToken  extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = -3230226253450874315L;
	private JwtCredentials credentials;
    private String token;

    public DigitalGourmetAuthenticationToken(JwtCredentials credentials) {
        super(null, null);
        this.credentials = credentials;
    }

    @Override
    public JwtCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(JwtCredentials credentials) {
        this.credentials = credentials;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
