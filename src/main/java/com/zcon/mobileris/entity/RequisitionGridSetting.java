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
@Table(name = "RequisitionGridSetting")
public class RequisitionGridSetting{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "RequisitionGridSettingId")
    private int requisitionGridSettingId;
    
    @Column(name = "RequisitionGridSettingSequence")
    private String requisitionGridSettingSequence;
    
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

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

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "RequisitionGridSetting{" + "requisitionGridSettingId=" + requisitionGridSettingId + ", requisitionGridSettingSequence=" + requisitionGridSettingSequence + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
}
