package com.example.ram.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "resource_skill")
public class ResourceSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_skill", referencedColumnName = "id")
    private TechnicalSkill technicalSkill;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_resource", referencedColumnName = "id")
    private Resource resource;

    public ResourceSkill(long id, TechnicalSkill technicalSkill, Resource resource) {
        this.id = id;
        this.technicalSkill = technicalSkill;
        this.resource = resource;
    }

    public ResourceSkill() {

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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
