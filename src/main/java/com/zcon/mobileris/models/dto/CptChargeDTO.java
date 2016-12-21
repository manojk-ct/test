    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;

/**
 *
 * @author PradnyaS
 */
public class CptChargeDTO implements Serializable{
    private int cptChargeId;
    @Min(1)
    private int cpt_Id;
    @Min(1)
    private int payer_Id;
    @Min(1)
    private int stateId;
    @Min(1)
    private int dispatchRegionId;
    private int tcCharge;
    private int charge26;
    private int gcCharge;
    private int medicareAllowed;
    private int medicarePay;
    private int patientPay;
    private int payFlagListValueId;
    private String limitingCharges;
    private int chargeTypeListvalueId;
    private int followsDays;    
    private String formCode;
    private String formCodeName;
    private String formProgramName;
    private int posAllowedListValueId;    
    private String chargeDescription;
    private String remark;
    private boolean isDeleted;
    private boolean status;
    
    public int getCptChargeId() {
        return cptChargeId;
    }

    public void setCptChargeId(int cptChargeId) {
        this.cptChargeId = cptChargeId;
    }

    public int getCpt_Id() {
        return cpt_Id;
    }

    public void setCpt_Id(int cpt_Id) {
        this.cpt_Id = cpt_Id;
    }

    public int getPayer_Id() {
        return payer_Id;
    }

    public void setPayer_Id(int payer_Id) {
        this.payer_Id = payer_Id;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getDispatchRegionId() {
        return dispatchRegionId;
    }

    public void setDispatchRegionId(int dispatchRegionId) {
        this.dispatchRegionId = dispatchRegionId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CptChargeDTO{" + "cptChargeId=" + cptChargeId + ", cpt_Id=" + cpt_Id + ", payer_Id=" + payer_Id + ", stateId=" + stateId + ", dispatchRegionId=" + dispatchRegionId + ", tcCharge=" + tcCharge + ", charge26=" + charge26 + ", gcCharge=" + gcCharge + ", medicareAllowed=" + medicareAllowed + ", medicarePay=" + medicarePay + ", patientPay=" + patientPay + ", payFlagListValueId=" + payFlagListValueId + ", limitingCharges=" + limitingCharges + ", chargeTypeListvalueId=" + chargeTypeListvalueId + ", followsDays=" + followsDays + ", formCode=" + formCode + ", formCodeName=" + formCodeName + ", formProgramName=" + formProgramName + ", posAllowedListValueId=" + posAllowedListValueId + ", chargeDescription=" + chargeDescription + ", remark=" + remark + ", isDeleted=" + isDeleted + '}';
    }

   
}
