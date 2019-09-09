package com.ignatyuk.shortcuts.validators;

import com.ignatyuk.shortcuts.models.Environment;
import com.ignatyuk.shortcuts.repositories.EnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnvironmentValidator {

    private EnvironmentRepository environmentRepository;

    public EnvironmentValidator(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }

    public boolean validate(Environment environment) {

        Collection<Environment> environments = environmentRepository.findAll();

        for(Environment env : environments) {
            if(environment.getEnvName().toLowerCase().equals(env.getEnvName().toLowerCase())) {
                return false;
            }
        }

        return true;
    }

}
