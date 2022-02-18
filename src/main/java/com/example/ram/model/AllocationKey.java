package com.example.ram.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AllocationKey implements Serializable {

    @Column(name = "id_assignment")
    private long idAssignment;

    @Column(name = "id_resource")
    private long idResource;

    private String type;

    public AllocationKey(long idAssignment, long idResource, String type) {
        this.idAssignment = idAssignment;
        this.idResource = idResource;
        this.type = type;
    }

    public AllocationKey() {

    }

    public long getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(long idAssignment) {
        this.idAssignment = idAssignment;
    }

    public long getIdResource() {
        return idResource;
    }

    public void setIdResource(long idResource) {
        this.idResource = idResource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationKey that = (AllocationKey) o;
        return idAssignment == that.idAssignment && idResource == that.idResource && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssignment, idResource, type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
