package com.example.ram.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectSkillKey implements Serializable {

    @Column(name = "id_project")
    private long idProject;

    @Column(name = "id_skill")
    private long idSkill;

    public ProjectSkillKey() {

    }

    public ProjectSkillKey(long idProject, long idSkill) {
        this.idProject = idProject;
        this.idSkill = idSkill;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(long idSkill) {
        this.idSkill = idSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectSkillKey that = (ProjectSkillKey) o;
        return idProject == that.idProject && idSkill == that.idSkill;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProject, idSkill);
    }
}

