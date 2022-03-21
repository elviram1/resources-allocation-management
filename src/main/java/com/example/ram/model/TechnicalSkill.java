package com.example.ram.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "technical_skill")
public class TechnicalSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String skill;
    private String type;

    @OneToMany(mappedBy = "technicalSkill" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProjectSkill> projectSkills;

    @OneToMany(mappedBy = "technicalSkill" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ResourceSkill> resourceSkills;

    public TechnicalSkill(long id, String skill, String type) {
        this.id = id;
        this.skill = skill;
        this.type = type;
    }

    public TechnicalSkill() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
