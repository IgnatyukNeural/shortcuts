package com.ignatyuk.shortcuts.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Shortcut {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 2, max = 40)
    private String shortcutDescription;

    @Length(min = 2, max = 20)
    private String keyboardCombination;

    @ManyToOne
    @JoinColumn(name = "parent_env_id", nullable = false)
    private Environment parentEnvironment;

    public Integer getId() {
        return id;
    }

    public String getShortcutDescription() {
        return shortcutDescription;
    }

    public String getKeyboardCombination() {
        return keyboardCombination;
    }

    public Environment getParentEnvironment() {
        return parentEnvironment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShortcutDescription(String shortcutDescription) {
        this.shortcutDescription = shortcutDescription;
    }

    public void setKeyboardCombination(String keyboardCombination) {
        this.keyboardCombination = keyboardCombination;
    }

    public void setParentEnvironment(Environment parentEnvironment) {
        this.parentEnvironment = parentEnvironment;
    }
}
