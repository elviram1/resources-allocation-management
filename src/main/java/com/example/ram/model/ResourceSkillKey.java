package com.example.ram.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResourceSkillKey implements Serializable {

    @Column(name = "id_resource")
    private long idResource;
    @Column(name = "id_skill")
    private long idSkill;

    public ResourceSkillKey(long idResource, long idSkill) {
        this.idResource = idResource;
        this.idSkill = idSkill;
    }

    public ResourceSkillKey() {

    }

    public long getIdResource() {
        return idResource;
    }

    public void setIdResource(long idResource) {
        this.idResource = idResource;
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
        ResourceSkillKey that = (ResourceSkillKey) o;
        return idResource == that.idResource && idSkill == that.idSkill;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResource, idSkill);
    }
}
