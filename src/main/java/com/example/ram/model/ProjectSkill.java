package com.example.ram.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "project_skill")
public class ProjectSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_skill", referencedColumnName = "id")
    private TechnicalSkill technicalSkill;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    public ProjectSkill(long id, TechnicalSkill technicalSkill, Project project) {
        this.id = id;
        this.technicalSkill = technicalSkill;
        this.project = project;
    }

    public ProjectSkill() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TechnicalSkill getTechnicalSkill() {
        return technicalSkill;
    }

    public void setTechnicalSkill(TechnicalSkill technicalSkill) {
        this.technicalSkill = technicalSkill;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
