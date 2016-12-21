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
public class RequisitionGridSettingDTO implements Serializable{
    private int requisitionGridSettingId;
    private String requisitionGridSettingSequence;
    private boolean isDeleted;

    public int getRequisitionGridSettingId() {
        return requisitionGridSettingId;
    }

    public void setRequisitionGridSettingId(int requisitionGridSettingId) {
        this.requisitionGridSettingId = requisitionGridSettingId;
    }

    public String getRequisitionGridSettingSequence() {
        return requisitionGridSettingSequence;
    }

    public void setRequisitionGridSettingSequence(String requisitionGridSettingSequence) {
        this.requisitionGridSettingSequence = requisitionGridSettingSequence;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "RequisitionGridSettingDTO{" + "requisitionGridSettingId=" + requisitionGridSettingId + ", requisitionGridSettingSequence=" + requisitionGridSettingSequence + ", isDeleted=" + isDeleted + '}';
    }
   
}
