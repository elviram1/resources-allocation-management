package com.example.ram.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "allocation")
public class Allocation {

    @EmbeddedId
    private AllocationKey allocationKey;

    private Date startDate;
    private Date endDate;
    private int percentageOfEngagement;
    private boolean investment;
    private boolean support;
    private boolean hypothesis;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    @ManyToOne
    @JoinColumn(name = "id_resource", referencedColumnName = "id", insertable=false, updatable=false)
    private Resource resource;

    @ManyToOne
    @JoinColumn(name = "id_assignment", referencedColumnName = "id", insertable=false, updatable=false)
    private Project project;

    public Allocation(AllocationKey allocationKey, Date startDate, Date endDate, int percentageOfEngagement, boolean investment, boolean support, boolean hypothesis, String metadata) {
        this.allocationKey = allocationKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentageOfEngagement = percentageOfEngagement;
        this.investment = investment;
        this.support = support;
        this.hypothesis = hypothesis;
        this.metadata = metadata;
    }

    public Allocation() {

    }

    public AllocationKey getAllocationKey() {
        return allocationKey;
    }

    public void setAllocationKey(AllocationKey allocationKey) {
        this.allocationKey = allocationKey;
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
}
