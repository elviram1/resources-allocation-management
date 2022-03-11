package com.example.ram.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;
    private Date endDate;
    private int percentageOfEngagement;
    private boolean investment;
    private boolean support;
    private boolean hypothesis;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_resource", referencedColumnName = "id")
    private Resource resource;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_resource_followed", referencedColumnName = "id")
    private Resource resourceFollowed;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    public Allocation(long id, Date startDate, Date endDate, int percentageOfEngagement, boolean investment, boolean support, boolean hypothesis, String metadata, Resource resource, Resource resourceFollowed, Project project) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentageOfEngagement = percentageOfEngagement;
        this.investment = investment;
        this.support = support;
        this.hypothesis = hypothesis;
        this.metadata = metadata;
        this.resource = resource;
        this.resourceFollowed = resourceFollowed;
        this.project = project;
    }

    public Allocation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPercentageOfEngagement() {
        return percentageOfEngagement;
    }

    public void setPercentageOfEngagement(int percentageOfEngagement) {
        this.percentageOfEngagement = percentageOfEngagement;
    }

    public boolean isInvestment() {
        return investment;
    }

    public void setInvestment(boolean investment) {
        this.investment = investment;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResourceFollowed() {
        return resourceFollowed;
    }

    public void setResourceFollowed(Resource resourceFollowed) {
        this.resourceFollowed = resourceFollowed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
