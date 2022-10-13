package com.ampada.taskmanagementwithmongo.config;

import com.ampada.taskmanagementwithmongo.security.entity.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private ActiveUser activeUser;

    @Override
    public Optional<String> getCurrentAuditor() {


        return Optional.of(activeUser.getUserName());
    }
}

