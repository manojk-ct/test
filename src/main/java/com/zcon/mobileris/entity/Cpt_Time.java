/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "cpt_time")
public class Cpt_Time{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cptTimeCodeId;
    
    @Column(name = "CptId", insertable = false, updatable = false)
    private int cptId;
    
    @Column(name = "CptTime")
    private java.sql.Time cptTime;
    
    @Column(name = "CptTimeCode")
    private String cptTimeCode;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Remark")
    private String remark;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @Embedded
    private AbstractCommonEntity commonComponent;
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
     
    public int getCptTimeCodeId() {
        return cptTimeCodeId;
    }

    public void setCptTimeCodeId(int cptTimeCodeId) {
        this.cptTimeCodeId = cptTimeCodeId;
    }

    public int getCptId() {
        return cptId;
    }

    public void setCptId(int cptId) {
        this.cptId = cptId;
    }

    public Time getCptTime() {
        return cptTime;
    }

    public void setCptTime(Time cptTime) {
        this.cptTime = cptTime;
    }

    public String getCptTimeCode() {
        return cptTimeCode;
    }

    public void setCptTimeCode(String cptTimeCode) {
        this.cptTimeCode = cptTimeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Cpt_Time{" + "cptTimeCodeId=" + cptTimeCodeId + ", cptId=" + cptId + ", cptTime=" + cptTime + ", cptTimeCode=" + cptTimeCode + ", description=" + description + ", remark=" + remark + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
