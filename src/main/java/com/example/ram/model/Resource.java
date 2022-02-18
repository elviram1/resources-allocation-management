package com.example.ram.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String initials;
    private String level;
    private boolean internalExternal;
    private int dailyHours;

    @Column(columnDefinition="TEXT")
    private String metadata;

    @OneToMany(mappedBy = "resource")
    private Set<ResourceSkill> resourceSkills;

    @OneToMany(mappedBy = "resource")
    private  Set<Allocation> allocations;

    public Resource(long id, String name, String surname, String initials, String level, boolean internalExternal, int dailyHours, String metadata) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.initials = initials;
        this.level = level;
        this.internalExternal = internalExternal;
        this.dailyHours = dailyHours;
        this.metadata = metadata;
    }

    public Resource() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isInternalExternal() {
        return internalExternal;
    }

    public void setInternalExternal(boolean internalExternal) {
        this.internalExternal = internalExternal;
    }

    public int getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(int dailyHours) {
        this.dailyHours = dailyHours;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
