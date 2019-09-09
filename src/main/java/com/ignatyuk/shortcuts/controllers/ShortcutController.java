package com.ignatyuk.shortcuts.controllers;

import com.ignatyuk.shortcuts.models.Environment;
import com.ignatyuk.shortcuts.models.Shortcut;
import com.ignatyuk.shortcuts.repositories.EnvironmentRepository;
import com.ignatyuk.shortcuts.repositories.ShortcutRepository;
import com.ignatyuk.shortcuts.validators.ShortcutValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ShortcutController {

    private ShortcutRepository shortcutRepository;
    private EnvironmentRepository environmentRepository;
    private ShortcutValidator shortcutValidator;

    public ShortcutController(ShortcutRepository shortcutRepository, EnvironmentRepository environmentRepository, ShortcutValidator shortcutValidator) {
        this.shortcutRepository = shortcutRepository;
        this.environmentRepository = environmentRepository;
        this.shortcutValidator = shortcutValidator;
    }

    @GetMapping("/create_shortcut/{envId}")
    public String createShortcut(Model model, @PathVariable("envId") String parentEnvId) {

        model.addAttribute("shortcut", new Shortcut());
        model.addAttribute("parentEnvId", parentEnvId);

        return "create_shortcut";
    }

    //TODO: StackOverflowError: null
    @PostMapping("/create_shortcut/{parentEnvId}")
    public String createShortcut(@PathVariable("parentEnvId") String parentEnvId, @ModelAttribute("shortcut") Shortcut shortcut) {

        Integer parentId = Integer.parseInt(parentEnvId);

        Optional<Environment> parentEnv =  environmentRepository.findById(parentId);

        if(parentEnv.isPresent()) {
            if(shortcutValidator.validate(parentEnv.get(), shortcut)) {
                shortcut.setParentEnvironment(parentEnv.get());
                shortcutRepository.save(shortcut);
            }
        }

        return "redirect:/";

    }

}
