package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PravinP
 */
@Entity
@Table(name = "Branches")
public class Branches{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BrancheId")
    private int brancheId;
    
    @Column(name = "BranchName",length = 45)
    private String branchName;
    
    @Column(name = "TenantId")
    private int tenantId;
    
    @Column(name = "Description",length = 255)
    private String description;
    
    @Column(name = "IsActive", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isActive;

    @Embedded
    private AbstractCommonEntity commonComponent;

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }
    
    
    public int getBrancheId() {
        return brancheId;
    }

    public void setBrancheId(int brancheId) {
        this.brancheId = brancheId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "Branches{" + "brancheId=" + brancheId + ", branchName=" + branchName + ", tenantId=" + tenantId + ", description=" + description + ", isActive=" + isActive + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
