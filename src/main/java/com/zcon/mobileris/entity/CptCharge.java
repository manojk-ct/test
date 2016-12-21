/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author MayuriM
 */
@Entity
@Table(name = "CptCharge")
public class CptCharge{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CptChargeId")
    private int cptChargeId;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "CptId")
    private CptCode cptObject;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "PayerId")
    private Payer payerObject;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "StateId")
    private States stateObject;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "DispatchRegionId")
    private DispatchRegions dispatchRegionObject;
    
    @Column(name = "TCCharge")
    private int tcCharge;
    
    @Column(name = "Charge26")
    private int charge26;
    
    @Column(name = "GCCharge")
    private int gcCharge;
    
    @Column(name = "MedicareAllowed")
    private int medicareAllowed;
    
    @Column(name = "MedicarePay")
    private int medicarePay;
    
    @Column(name = "PatientPay")
    private int patientPay;
    
    @Column(name = "PayFlagListValueId")
    private int payFlagListValueId;
    
    @Column(name = "LimitingCharges")
    private String limitingCharges;

    @Column(name = "ChargeTypeListvalueId")
    private int chargeTypeListvalueId;

    @Column(name = "FollowsDays")
    private int followsDays;    
    
    @Column(name = "FormCode")
    private String formCode;
 
    @Column(name = "FormCodeName")
    private String formCodeName;
 
    @Column(name = "FormProgramName")
    private String formProgramName;
 
    @Column(name = "PosAllowedListValueId")
    private int posAllowedListValueId;    
    
    @Column(name = "ChargeDescription")
    private String chargeDescription;
    
    @Column(name = "Remark")
    private String remark;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Column(name = "Status")
    private boolean status;

    @Embedded
    private AbstractCommonEntity commonComponent;
    
    public int getCptChargeId() {
        return cptChargeId;
    }

    public void setCptChargeId(int cptChargeId) {
        this.cptChargeId = cptChargeId;
    }

    public CptCode getCptObject() {
        return cptObject;
    }

    public void setCptObject(CptCode cptObject) {
        this.cptObject = cptObject;
    }

    public Payer getPayerObject() {
        return payerObject;
    }

    public void setPayerObject(Payer payerObject) {
        this.payerObject = payerObject;
    }

    public States getStateObject() {
        return stateObject;
    }

    public void setStateObject(States stateObject) {
        this.stateObject = stateObject;
    }

    public DispatchRegions getDispatchRegionObject() {
        return dispatchRegionObject;
    }

    public void setDispatchRegionObject(DispatchRegions dispatchRegionObject) {
        this.dispatchRegionObject = dispatchRegionObject;
    }

    public int getTcCharge() {
        return tcCharge;
    }

    public void setTcCharge(int tcCharge) {
        this.tcCharge = tcCharge;
    }

    public int getCharge26() {
        return charge26;
    }

    public void setCharge26(int charge26) {
        this.charge26 = charge26;
    }

    public int getGcCharge() {
        return gcCharge;
    }

    public void setGcCharge(int gcCharge) {
        this.gcCharge = gcCharge;
    }

    public int getMedicareAllowed() {
        return medicareAllowed;
    }

    public void setMedicareAllowed(int medicareAllowed) {
        this.medicareAllowed = medicareAllowed;
    }

    public int getMedicarePay() {
        return medicarePay;
    }

    public void setMedicarePay(int medicarePay) {
        this.medicarePay = medicarePay;
    }

    public int getPatientPay() {
        return patientPay;
    }

    public void setPatientPay(int patientPay) {
        this.patientPay = patientPay;
    }

    public int getPayFlagListValueId() {
        return payFlagListValueId;
    }

    public void setPayFlagListValueId(int payFlagListValueId) {
        this.payFlagListValueId = payFlagListValueId;
    }

    public String getLimitingCharges() {
        return limitingCharges;
    }

    public void setLimitingCharges(String limitingCharges) {
        this.limitingCharges = limitingCharges;
    }

    public int getChargeTypeListvalueId() {
        return chargeTypeListvalueId;
    }

    public void setChargeTypeListvalueId(int chargeTypeListvalueId) {
        this.chargeTypeListvalueId = chargeTypeListvalueId;
    }

    public int getFollowsDays() {
        return followsDays;
    }

    public void setFollowsDays(int followsDays) {
        this.followsDays = followsDays;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getFormCodeName() {
        return formCodeName;
    }

    public void setFormCodeName(String formCodeName) {
        this.formCodeName = formCodeName;
    }

    public String getFormProgramName() {
        return formProgramName;
    }

    public void setFormProgramName(String formProgramName) {
        this.formProgramName = formProgramName;
    }

    public int getPosAllowedListValueId() {
        return posAllowedListValueId;
    }

    public void setPosAllowedListValueId(int posAllowedListValueId) {
        this.posAllowedListValueId = posAllowedListValueId;
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        this.chargeDescription = chargeDescription;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "CptCharge{" + "cptChargeId=" + cptChargeId + ", cptObject=" + cptObject + ", payerObject=" + payerObject + ", stateObject=" + stateObject + ", dispatchRegionObject=" + dispatchRegionObject + ", tcCharge=" + tcCharge + ", charge26=" + charge26 + ", gcCharge=" + gcCharge + ", medicareAllowed=" + medicareAllowed + ", medicarePay=" + medicarePay + ", patientPay=" + patientPay + ", payFlagListValueId=" + payFlagListValueId + ", limitingCharges=" + limitingCharges + ", chargeTypeListvalueId=" + chargeTypeListvalueId + ", followsDays=" + followsDays + ", formCode=" + formCode + ", formCodeName=" + formCodeName + ", formProgramName=" + formProgramName + ", posAllowedListValueId=" + posAllowedListValueId + ", chargeDescription=" + chargeDescription + ", remark=" + remark + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
 
    
}
