package com.jas.digitalgourmet.model.auditable;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	JwtCredentials jwtCredentials = (JwtCredentials)authentication.getCredentials();
    	
        return Optional.of(jwtCredentials.getUserName());
    }

}