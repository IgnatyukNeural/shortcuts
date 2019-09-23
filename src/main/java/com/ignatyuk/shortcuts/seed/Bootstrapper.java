package com.ignatyuk.shortcuts.seed;

import com.ignatyuk.shortcuts.models.Environment;
import com.ignatyuk.shortcuts.models.Shortcut;
import com.ignatyuk.shortcuts.repositories.EnvironmentRepository;
import com.ignatyuk.shortcuts.repositories.ShortcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrapper implements CommandLineRunner {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @Autowired
    private ShortcutRepository shortcutRepository;

    @Override
    public void run(String... args) throws Exception {

        Environment environment = new Environment();
        environment.setEnvName("VS Code");
        environment.setEnvDescription("An IDE originally developed by Microsoft that supports a large variety of languages");

        environmentRepository.save(environment);

        Environment environment1 = new Environment();
        environment1.setEnvName("IntelliJ Idea");
        environment1.setEnvDescription("A free/paid IDE for developing Java applications");

        environmentRepository.save(environment1);


        Environment environment2 = new Environment();
        environment2.setEnvName("Chrome");
        environment2.setEnvDescription("A browser developed by Google");

        environmentRepository.save(environment2);


        Shortcut shortcut = new Shortcut();
        shortcut.setShortcutDescription("Duplicate line");
        shortcut.setKeyboardCombination("Ctrl + D");
        shortcut.setParentEnvironment(environment);

        shortcutRepository.save(shortcut);

        Shortcut shortcut1 = new Shortcut();
        shortcut1.setShortcutDescription("Open the code generation panel");
        shortcut1.setKeyboardCombination("Alt + Insert");
        shortcut1.setParentEnvironment(environment1);

        shortcutRepository.save(shortcut1);

        Shortcut shortcut2 = new Shortcut();
        shortcut2.setShortcutDescription("Copy all");
        shortcut2.setKeyboardCombination("Ctrl + A");
        shortcut2.setParentEnvironment(environment1);

        shortcutRepository.save(shortcut2);

        Shortcut shortcut3 = new Shortcut();
        shortcut3.setShortcutDescription("Close current tab");
        shortcut3.setKeyboardCombination("Ctrl + W");
        shortcut3.setParentEnvironment(environment2);

        shortcutRepository.save(shortcut3);

        Shortcut shortcut4 = new Shortcut();
        shortcut4.setShortcutDescription("Open a new tab");
        shortcut4.setKeyboardCombination("Ctrl + T");
        shortcut4.setParentEnvironment(environment2);

        shortcutRepository.save(shortcut4);

    }
}
