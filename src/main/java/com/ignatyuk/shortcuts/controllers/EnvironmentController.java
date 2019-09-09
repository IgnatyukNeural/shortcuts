package com.ignatyuk.shortcuts.controllers;

import com.ignatyuk.shortcuts.models.Environment;
import com.ignatyuk.shortcuts.repositories.EnvironmentRepository;
import com.ignatyuk.shortcuts.validators.EnvironmentValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EnvironmentController {

    private EnvironmentRepository environmentRepository;
    private EnvironmentValidator environmentValidator;

    public EnvironmentController(EnvironmentRepository environmentRepository, EnvironmentValidator environmentValidator) {
        this.environmentRepository = environmentRepository;
        this.environmentValidator = environmentValidator;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("environments", environmentRepository.findAll());

        return "index";
    }

    @GetMapping("/environment/{id}")
    public String findById(@PathVariable("id") String id, Model model) {

        Optional<Environment> environment = environmentRepository.findById(Integer.parseInt(id));

        if(environment.isPresent()) {
            model.addAttribute("environment", environment.get());
            return "environment";
        }

        return "redirect:/";
    }

    @GetMapping("create_environment")
    public String createEnvironment(Model model) {

        model.addAttribute("environment", new Environment());

        return "create_environment";
    }

    @PostMapping("create_environment")
    public String createEnvironment(@ModelAttribute Environment environment) {

        if (environmentValidator.validate(environment)) {
            environmentRepository.save(environment);
        }

        return "redirect:/";
    }

}
