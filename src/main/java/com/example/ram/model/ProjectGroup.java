package com.example.ram.model;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "project_group")
public class ProjectGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String agency;
    private String color;

    @OneToMany(mappedBy = "projectGroup")
    private Set<Project> projects;

    public ProjectGroup(long id, String agency, String color) {
        this.id = id;
        this.agency = agency;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
