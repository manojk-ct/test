/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PradnyaS
 */
public class PayerDTO  implements Serializable {
    @NotNull
    private int payerId;
    @NotNull
    @Length(min=1,max = 35)
    private String payerName;
    private String addressLine1;
    private String addressLine2;
    private String payerCode;
    private String city;
    @NotNull
    private int stateId;
    @NotNull
    private int countryId;
    private long zipCode;
    private long landLineExtension;
    private String landLine1;
    private String landLine2;
    @Email
    private String emailId;
    private long faxNumber;
    private String defaultRate;
    private String identification;
    private String insuranceType;
    private String claimOfficeNumber;
    private String claimType;
    private String submissionType;
    private String payerRemark;
    private String eligibilityClearingHouse;
    private String eligibilityPayer;
    private String claimClearingHouse;
    private String claimPayer;
    private boolean isDeleted;

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public long getLandLineExtension() {
        return landLineExtension;
    }

    public void setLandLineExtension(long landLineExtension) {
        this.landLineExtension = landLineExtension;
    }

    public String getLandLine1() {
        return landLine1;
    }

    public void setLandLine1(String landLine1) {
        this.landLine1 = landLine1;
    }

    public String getLandLine2() {
        return landLine2;
    }

    public void setLandLine2(String landLine2) {
        this.landLine2 = landLine2;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(long faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(String defaultRate) {
        this.defaultRate = defaultRate;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getClaimOfficeNumber() {
        return claimOfficeNumber;
    }

    public void setClaimOfficeNumber(String claimOfficeNumber) {
        this.claimOfficeNumber = claimOfficeNumber;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public String getPayerRemark() {
        return payerRemark;
    }

    public void setPayerRemark(String payerRemark) {
        this.payerRemark = payerRemark;
    }

    public String getEligibilityClearingHouse() {
        return eligibilityClearingHouse;
    }

    public void setEligibilityClearingHouse(String eligibilityClearingHouse) {
        this.eligibilityClearingHouse = eligibilityClearingHouse;
    }

    public String getEligibilityPayer() {
        return eligibilityPayer;
    }

    public void setEligibilityPayer(String eligibilityPayer) {
        this.eligibilityPayer = eligibilityPayer;
    }

    public String getClaimClearingHouse() {
        return claimClearingHouse;
    }

    public void setClaimClearingHouse(String claimClearingHouse) {
        this.claimClearingHouse = claimClearingHouse;
    }

    public String getClaimPayer() {
        return claimPayer;
    }

    public void setClaimPayer(String claimPayer) {
        this.claimPayer = claimPayer;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "PayerDTO{" + "payerId=" + payerId + ", payerName=" + payerName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", payerCode=" + payerCode + ", city=" + city + ", stateId=" + stateId + ", countryId=" + countryId + ", zipCode=" + zipCode + ", landLineExtension=" + landLineExtension + ", landLine1=" + landLine1 + ", landLine2=" + landLine2 + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", defaultRate=" + defaultRate + ", identification=" + identification + ", insuranceType=" + insuranceType + ", claimOfficeNumber=" + claimOfficeNumber + ", claimType=" + claimType + ", submissionType=" + submissionType + ", payerRemark=" + payerRemark + ", eligibilityClearingHouse=" + eligibilityClearingHouse + ", eligibilityPayer=" + eligibilityPayer + ", claimClearingHouse=" + claimClearingHouse + ", claimPayer=" + claimPayer + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
