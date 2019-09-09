package com.ignatyuk.shortcuts.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length(min = 2, max = 30)
    private String envName;

    @NotNull
    @Length(min = 10, max = 300)
    private String envDescription;

    @OneToMany(mappedBy = "parentEnvironment")
    private Set<Shortcut> shortcuts;

    public Integer getId() {
        return id;
    }

    public String getEnvName() {
        return envName;
    }

    public String getEnvDescription() {
        return envDescription;
    }

    public Set<Shortcut> getShortcuts() {
        return shortcuts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public void setEnvDescription(String envDescription) {
        this.envDescription = envDescription;
    }

    public void setShortcuts(Set<Shortcut> shortcuts) {
        this.shortcuts = shortcuts;
    }
}
