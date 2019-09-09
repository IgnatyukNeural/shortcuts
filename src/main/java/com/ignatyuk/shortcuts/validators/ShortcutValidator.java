package com.ignatyuk.shortcuts.validators;

import com.ignatyuk.shortcuts.models.Environment;
import com.ignatyuk.shortcuts.models.Shortcut;
import com.ignatyuk.shortcuts.repositories.EnvironmentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class ShortcutValidator {

    private EnvironmentRepository environmentRepository;

    public ShortcutValidator(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }

    public boolean validate(Environment environment, Shortcut shortcut) {

         Collection<Shortcut> shortcuts = environment.getShortcuts();

        for(Shortcut sc : shortcuts) {
            if (sc.getShortcutDescription().toLowerCase().equals(shortcut.getShortcutDescription().toLowerCase())) {
                return false;
            }
        }

        return true;
    }

}
