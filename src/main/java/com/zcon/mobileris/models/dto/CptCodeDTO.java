/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PradnyaS
 */
public class CptCodeDTO implements Serializable{
   
    private int cptId;
    @NotNull
    @Length(min=1,max = 35)
    private String cptCode;
    private String shortDescription;
    private String longDescription;
    private String procView;
    private int bodyPartExamId;
    private String remark;
    private int placeOfService;
    private java.sql.Time cptTime;
    private String cptCodeRule;
    private boolean isDeleted;
    private boolean status;
    private Set<Cpt_TimeDTO> cptTimeObject;
    
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

    public int getBodyPartExamId() {
        return bodyPartExamId;
    }

    public void setBodyPartExamId(int bodyPartExamId) {
        this.bodyPartExamId = bodyPartExamId;
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

    public Set<Cpt_TimeDTO> getCptTimeObject() {
        return cptTimeObject;
    }

    public void setCptTimeObject(Set<Cpt_TimeDTO> cptTimeObject) {
        this.cptTimeObject = cptTimeObject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CptCodeDTO{" + "cptId=" + cptId + ", cptCode=" + cptCode + ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", procView=" + procView + ", bodyPartExamId=" + bodyPartExamId + ", remark=" + remark + ", placeOfService=" + placeOfService + ", cptTime=" + cptTime + ", cptCodeRule=" + cptCodeRule + ", isDeleted=" + isDeleted + ", cptTimeObject=" + cptTimeObject + '}';
    }

}
