/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
/**
 *
 * @author PradnyaS
 */
public class PatientGridSettingDTO implements Serializable{
    
    private int patientGridSettingId;
    private String patientGridSettingSequence;
    private boolean isDeleted;

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

    @Override
    public String toString() {
        return "PatientGridSettingDTO{" + "patientGridSettingId=" + patientGridSettingId + ", patientGridSettingSequence=" + patientGridSettingSequence + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
