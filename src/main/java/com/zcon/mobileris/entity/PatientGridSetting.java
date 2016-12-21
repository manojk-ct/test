/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author PradnyaS
 */
@Entity
@Table(name = "PatientGridSetting")
public class PatientGridSetting{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PatientGridSettingId")
    private int patientGridSettingId;
    
    @Column(name = "PatientGridSettingSequence")
    private String patientGridSettingSequence;
    
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getPatientGridSettingId() {
        return patientGridSettingId;
    }

    public void setPatientGridSettingId(int patientGridSettingId) {
        this.patientGridSettingId = patientGridSettingId;
    }

    public String getPatientGridSettingSequence() {
        return patientGridSettingSequence;
    }

    public void setPatientGridSettingSequence(String patientGridSettingSequence) {
        this.patientGridSettingSequence = patientGridSettingSequence;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "PatientGridSetting{" + "patientGridSettingId=" + patientGridSettingId + ", patientGridSettingSequence=" + patientGridSettingSequence + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
   
    
}
