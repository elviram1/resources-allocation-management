package com.example.ram.model;

import javax.persistence.*;

@Entity
@Table(name = "resource_skill")
public class ResourceSkill {

    @EmbeddedId
    private ResourceSkillKey resourceSkillKey;

    @ManyToOne
    @JoinColumn(name = "id_skill", referencedColumnName = "id", insertable=false, updatable=false)
    private TechnicalSkill technicalSkill;

    @ManyToOne
    @JoinColumn(name = "id_resource", referencedColumnName = "id", insertable=false, updatable=false)
    private Resource resource;


    public ResourceSkill(ResourceSkillKey resourceSkillKey) {
        this.resourceSkillKey = resourceSkillKey;
    }

    public ResourceSkill() {

    }

    public ResourceSkillKey getResourceSkillKey() {
        return resourceSkillKey;
    }

    public void setResourceSkillKey(ResourceSkillKey resourceSkillKey) {
        this.resourceSkillKey = resourceSkillKey;
    }
}
