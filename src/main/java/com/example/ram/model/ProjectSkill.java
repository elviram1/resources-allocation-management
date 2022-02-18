package com.example.ram.model;

import javax.persistence.*;

@Entity
public class ProjectSkill {
    @EmbeddedId
    private ProjectSkillKey projectSkillKey;

   // @MapsId("idProject")
    @ManyToOne
    @JoinColumn(name = "id_project", referencedColumnName = "id", insertable=false, updatable=false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id_skill", referencedColumnName = "id", insertable=false, updatable=false)
    private TechnicalSkill technicalSkill;

    public ProjectSkill() {

    }

    public ProjectSkill(ProjectSkillKey projectSkillKey) {
        this.projectSkillKey = projectSkillKey;
    }


    public ProjectSkillKey getProjectSkillId() {
        return projectSkillKey;
    }

    public void setProjectSkillId(ProjectSkillKey projectSkillKey) {
        this.projectSkillKey = projectSkillKey;
    }
}
