/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import com.zcon.mobileris.entity.Payer;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PradnyaS
 */
public class Patient_InsuranceDTO  implements Serializable{
    private int insuranceId;
    @NotNull
    @Length(min=1,max = 35)
    private String insuranceInfo;
    @NotNull
    @Length(min=1,max = 35)
    private String insuranceType;
    @Min(1)
    private int patientId;
    private String eligibilityStatus;
    private String statusMessage;
    private String checkedOn;
    private String coverage;
    private String usages;
    private boolean priorAuthorisation;
    private boolean inNetwork;
    private boolean outOfNetwork;
    private boolean referealNeccessary;
    private boolean selfGuarantor;
    private String guarantorFirstName;
    private String guarantorMiddleName;
    private String guarantorLastName;
    private String relationship;
    private String guarantorSSN;
    private Date guarantorDOB;
    private String guarantorGender;
    private long guarantorPhoneExtension;
    private String guarantorPhone;
    private String policyNo;
    private String groupId;
    private String contract;
    private String billingCode;
    private String network;
    private String insuranceTypeCode;
    private String employerName;
    private String schoolName;
    private float officeCoPay;
    private float deducibleRemaining;
    private long employerPhoneExtension;
    private String employerPhone;
    private String serviceType;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String adjusterFirstName;
    private String adjusterLastName;
    private long adjusterPhoneExtension;
    private String adjusterPhone;
    private String wcbCase;
    private String policyHolder;
    private String attorneyName;
    private long attorneyPhoneExtension;
    private String attorneyPhone;
//    private String claimAddressLine1;
//    private String claimAddressLine2;
//    private String claimCity;
//    private int claimStateId;
//    private int claimCountryId;
//    private long claimZipCode;
    private Payer payerId;
    private boolean isDeleted; 

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getEligibilityStatus() {
        return eligibilityStatus;
    }

    public void setEligibilityStatus(String eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getCheckedOn() {
        return checkedOn;
    }

    public void setCheckedOn(String checkedOn) {
        this.checkedOn = checkedOn;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages;
    }

    public boolean isPriorAuthorisation() {
        return priorAuthorisation;
    }

    public void setPriorAuthorisation(boolean priorAuthorisation) {
        this.priorAuthorisation = priorAuthorisation;
    }

    public boolean isInNetwork() {
        return inNetwork;
    }

    public void setInNetwork(boolean inNetwork) {
        this.inNetwork = inNetwork;
    }

    public boolean isOutOfNetwork() {
        return outOfNetwork;
    }

    public void setOutOfNetwork(boolean outOfNetwork) {
        this.outOfNetwork = outOfNetwork;
    }

    public boolean isReferealNeccessary() {
        return referealNeccessary;
    }

    public void setReferealNeccessary(boolean referealNeccessary) {
        this.referealNeccessary = referealNeccessary;
    }

    public boolean isSelfGuarantor() {
        return selfGuarantor;
    }

    public void setSelfGuarantor(boolean selfGuarantor) {
        this.selfGuarantor = selfGuarantor;
    }

    public String getGuarantorFirstName() {
        return guarantorFirstName;
    }

    public void setGuarantorFirstName(String guarantorFirstName) {
        this.guarantorFirstName = guarantorFirstName;
    }

    public String getGuarantorMiddleName() {
        return guarantorMiddleName;
    }

    public void setGuarantorMiddleName(String guarantorMiddleName) {
        this.guarantorMiddleName = guarantorMiddleName;
    }

    public String getGuarantorLastName() {
        return guarantorLastName;
    }

    public void setGuarantorLastName(String guarantorLastName) {
        this.guarantorLastName = guarantorLastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getGuarantorSSN() {
        return guarantorSSN;
    }

    public void setGuarantorSSN(String guarantorSSN) {
        this.guarantorSSN = guarantorSSN;
    }

    public Date getGuarantorDOB() {
        return guarantorDOB;
    }

    public void setGuarantorDOB(Date guarantorDOB) {
        this.guarantorDOB = guarantorDOB;
    }

    public String getGuarantorGender() {
        return guarantorGender;
    }

    public void setGuarantorGender(String guarantorGender) {
        this.guarantorGender = guarantorGender;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getInsuranceTypeCode() {
        return insuranceTypeCode;
    }

    public void setInsuranceTypeCode(String insuranceTypeCode) {
        this.insuranceTypeCode = insuranceTypeCode;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public float getOfficeCoPay() {
        return officeCoPay;
    }

    public void setOfficeCoPay(float officeCoPay) {
        this.officeCoPay = officeCoPay;
    }

    public float getDeducibleRemaining() {
        return deducibleRemaining;
    }

    public void setDeducibleRemaining(float deducibleRemaining) {
        this.deducibleRemaining = deducibleRemaining;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public String getAdjusterFirstName() {
        return adjusterFirstName;
    }

    public void setAdjusterFirstName(String adjusterFirstName) {
        this.adjusterFirstName = adjusterFirstName;
    }

    public String getAdjusterLastName() {
        return adjusterLastName;
    }

    public void setAdjusterLastName(String adjusterLastName) {
        this.adjusterLastName = adjusterLastName;
    }

    public long getGuarantorPhoneExtension() {
        return guarantorPhoneExtension;
    }

    public void setGuarantorPhoneExtension(long guarantorPhoneExtension) {
        this.guarantorPhoneExtension = guarantorPhoneExtension;
    }

    public String getGuarantorPhone() {
        return guarantorPhone;
    }

    public void setGuarantorPhone(String guarantorPhone) {
        this.guarantorPhone = guarantorPhone;
    }

    public long getEmployerPhoneExtension() {
        return employerPhoneExtension;
    }

    public void setEmployerPhoneExtension(long employerPhoneExtension) {
        this.employerPhoneExtension = employerPhoneExtension;
    }

    public String getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        this.employerPhone = employerPhone;
    }

    public long getAdjusterPhoneExtension() {
        return adjusterPhoneExtension;
    }

    public void setAdjusterPhoneExtension(long adjusterPhoneExtension) {
        this.adjusterPhoneExtension = adjusterPhoneExtension;
    }

    public String getAdjusterPhone() {
        return adjusterPhone;
    }

    public void setAdjusterPhone(String adjusterPhone) {
        this.adjusterPhone = adjusterPhone;
    }

    public long getAttorneyPhoneExtension() {
        return attorneyPhoneExtension;
    }

    public void setAttorneyPhoneExtension(long attorneyPhoneExtension) {
        this.attorneyPhoneExtension = attorneyPhoneExtension;
    }

    public String getAttorneyPhone() {
        return attorneyPhone;
    }

    public void setAttorneyPhone(String attorneyPhone) {
        this.attorneyPhone = attorneyPhone;
    }
    
    public String getWcbCase() {
        return wcbCase;
    }

    public void setWcbCase(String wcbCase) {
        this.wcbCase = wcbCase;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getAttorneyName() {
        return attorneyName;
    }

    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }

//    public String getClaimAddressLine1() {
//        return claimAddressLine1;
//    }
//
//    public void setClaimAddressLine1(String claimAddressLine1) {
//        this.claimAddressLine1 = claimAddressLine1;
//    }
//
//    public String getClaimAddressLine2() {
//        return claimAddressLine2;
//    }
//
//    public void setClaimAddressLine2(String claimAddressLine2) {
//        this.claimAddressLine2 = claimAddressLine2;
//    }
//
//    public String getClaimCity() {
//        return claimCity;
//    }
//
//    public void setClaimCity(String claimCity) {
//        this.claimCity = claimCity;
//    }
//
//    public long getClaimZipCode() {
//        return claimZipCode;
//    }
//
//    public void setClaimZipCode(long claimZipCode) {
//        this.claimZipCode = claimZipCode;
//    }
//
//    public int getClaimStateId() {
//        return claimStateId;
//    }
//
//    public void setClaimStateId(int claimStateId) {
//        this.claimStateId = claimStateId;
//    }
//
//    public int getClaimCountryId() {
//        return claimCountryId;
//    }
//
//    public void setClaimCountryId(int claimCountryId) {
//        this.claimCountryId = claimCountryId;
//    }

    public Payer getPayerId() {
        return payerId;
    }

    public void setPayerId(Payer payerId) {
        this.payerId = payerId;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Patient_InsuranceDTO{" + "insuranceId=" + insuranceId + ", insuranceInfo=" + insuranceInfo + ", insuranceType=" + insuranceType + ", patientId=" + patientId + ", eligibilityStatus=" + eligibilityStatus + ", statusMessage=" + statusMessage + ", checkedOn=" + checkedOn + ", coverage=" + coverage + ", usages=" + usages + ", priorAuthorisation=" + priorAuthorisation + ", inNetwork=" + inNetwork + ", outOfNetwork=" + outOfNetwork + ", referealNeccessary=" + referealNeccessary + ", selfGuarantor=" + selfGuarantor + ", guarantorFirstName=" + guarantorFirstName + ", guarantorMiddleName=" + guarantorMiddleName + ", guarantorLastName=" + guarantorLastName + ", relationship=" + relationship + ", guarantorSSN=" + guarantorSSN + ", guarantorDOB=" + guarantorDOB + ", guarantorGender=" + guarantorGender + ", guarantorPhoneExtension=" + guarantorPhoneExtension + ", guarantorPhone=" + guarantorPhone + ", policyNo=" + policyNo + ", groupId=" + groupId + ", contract=" + contract + ", billingCode=" + billingCode + ", network=" + network + ", insuranceTypeCode=" + insuranceTypeCode + ", employerName=" + employerName + ", schoolName=" + schoolName + ", officeCoPay=" + officeCoPay + ", deducibleRemaining=" + deducibleRemaining + ", employerPhoneExtension=" + employerPhoneExtension + ", employerPhone=" + employerPhone + ", serviceType=" + serviceType + ", effectiveStartDate=" + effectiveStartDate + ", effectiveEndDate=" + effectiveEndDate + ", adjusterFirstName=" + adjusterFirstName + ", adjusterLastName=" + adjusterLastName + ", adjusterPhoneExtension=" + adjusterPhoneExtension + ", adjusterPhone=" + adjusterPhone + ", wcbCase=" + wcbCase + ", policyHolder=" + policyHolder + ", attorneyName=" + attorneyName + ", attorneyPhoneExtension=" + attorneyPhoneExtension + ", attorneyPhone=" + attorneyPhone + ", payerId=" + payerId + ", isDeleted=" + isDeleted + '}';
    }

  
}
