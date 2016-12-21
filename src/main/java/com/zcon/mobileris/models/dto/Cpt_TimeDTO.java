/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author PradnyaS
 */
public class Cpt_TimeDTO implements Serializable{
   
    private int cptTimeCodeId;
    private int cptId;
    private java.sql.Time cptTime;
    private String cptTimeCode;
    private String description;
    private String remark;
    private boolean isDeleted;

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

    @Override
    public String toString() {
        return "Cpt_TimeDTO{" + "cptTimeCodeId=" + cptTimeCodeId + ", cptId=" + cptId + ", cptTime=" + cptTime + ", cptTimeCode=" + cptTimeCode + ", description=" + description + ", remark=" + remark + ", isDeleted=" + isDeleted + '}';
    }

}
