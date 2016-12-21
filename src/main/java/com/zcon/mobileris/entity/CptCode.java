/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

import java.sql.Time;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author MayuriM
 */
@Entity
@Table(name = "cpt")
public class CptCode{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CptId")
    private int cptId;
   
    @Column(name = "CptCode")
    private String cptCode;
    
    @Column(name = "ShortDescription")
    private String shortDescription;
    
    @Column(name = "LongDescription")
    private String longDescription;
    
    @Column(name = "ProcView")
    private String procView;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "BodyPartExamId")
    private BodyPartExam bodyPartExam;
    
    @Column(name = "Remark")
    private String remark;
    
    @Column(name = "PlaceOfService")
    private int placeOfService;
    
    @Column(name = "CptTime")
    private java.sql.Time cptTime;
    
    @Column(name = "CptCodeRule")
    private String cptCodeRule;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Column(name = "Status")
    private boolean status;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "cptId", nullable = false)
    private Set<Cpt_Time> cptTimeObject;

    @Embedded
    private AbstractCommonEntity commonComponent;

    public Set<Cpt_Time> getCptTimeObject() {
        return cptTimeObject;
    }

    public void setCptTimeObject(Set<Cpt_Time> cptTimeObject) {
        this.cptTimeObject = cptTimeObject;
    }
    
    public int getCptId() {
        return cptId;
    }

    public void setCptId(int cptId) {
        this.cptId = cptId;
    }

    public String getCptCode() {
        return cptCode;
    }

    public void setCptCode(String cptCode) {
        this.cptCode = cptCode;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getProcView() {
        return procView;
    }

    public void setProcView(String procView) {
        this.procView = procView;
    }

    public BodyPartExam getBodyPartExam() {
        return bodyPartExam;
    }

    public void setBodyPartExam(BodyPartExam bodyPartExam) {
        this.bodyPartExam = bodyPartExam;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPlaceOfService() {
        return placeOfService;
    }

    public void setPlaceOfService(int placeOfService) {
        this.placeOfService = placeOfService;
    }

    public String getCptCodeRule() {
        return cptCodeRule;
    }

    public void setCptCodeRule(String cptCodeRule) {
        this.cptCodeRule = cptCodeRule;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Time getCptTime() {
        return cptTime;
    }

    public void setCptTime(Time cptTime) {
        this.cptTime = cptTime;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CptCode{" + "cptId=" + cptId + ", cptCode=" + cptCode + ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", procView=" + procView + ", bodyPartExam=" + bodyPartExam + ", remark=" + remark + ", placeOfService=" + placeOfService + ", cptTime=" + cptTime + ", cptCodeRule=" + cptCodeRule + ", isDeleted=" + isDeleted + ", cptTimeObject=" + cptTimeObject + ", commonComponent=" + commonComponent + '}';
    }

    
}
