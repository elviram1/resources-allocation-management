package com.example.ram.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date startDate;
    private Date endDate;
    private int fteRequired;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private ProjectGroup projectGroup;

    @OneToMany(mappedBy = "project")
    private Set<ProjectSkill> projectSkill;

    @OneToMany(mappedBy = "project")
    private Set<Allocation> allocations;

    public Project(long id, String name, Date startDate, Date endDate, int fteRequired, String metadata, ProjectGroup projectGroup) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fteRequired = fteRequired;
        this.metadata = metadata;
        this.projectGroup = projectGroup;
    }

    public Project() {

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getFteRequired() {
        return fteRequired;
    }

    public void setFteRequired(int fteRequired) {
        this.fteRequired = fteRequired;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public ProjectGroup getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(ProjectGroup projectGroup) {
        this.projectGroup = projectGroup;
    }
}
