package com.jas.digitalgourmet.model.auditable;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
    	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of("Mr. Auditor");
    }

}