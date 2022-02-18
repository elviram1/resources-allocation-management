package com.example.ram.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "project_group")
public class ProjectGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String agency;

    @OneToMany(mappedBy = "projectGroup")
    private Set<Project> projects;

    public ProjectGroup(long id, String agency) {
        this.id = id;
        this.agency = agency;
    }

    public ProjectGroup() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
