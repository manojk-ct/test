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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "Payer")
public class Payer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PayerId")
    private int payerId;

    @Column(name = "PayerName")
    private String payerName;

    @NotEmpty
    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "AddressLine2")
    private String addressLine2;

    @Column(name = "PayerCode")
    private String payerCode;
    
    @Column(name = "City")
    private String city;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "StateId")
    private States state;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "CountryId")
    private Country country;

    @Column(name = "ZipCode")
    private long zipCode;

    @Column(name = "LandLineExtension")
    private long landLineExtension;
    
    @Column(name = "LandLine1")
    private String landLine1;

    @Column(name = "LandLine2")
    private String landLine2;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "FaxNumber")
    private long faxNumber;

    @Column(name = "DefaultRate")
    private String defaultRate;

    @Column(name = "Identification")
    private String identification;

    @Column(name = "InsuranceType")
    private String insuranceType;

    @Column(name = "ClaimOfficeNumber")
    private String claimOfficeNumber;

    @Column(name = "ClaimType")
    private String claimType;

    @Column(name = "SubmissionType")
    private String submissionType;

    @Column(name = "PayerRemark")
    private String payerRemark;

    @Column(name = "EligibilityClearingHouse")
    private String eligibilityClearingHouse;

    @Column(name = "EligibilityPayer")
    private String eligibilityPayer;

    @Column(name = "ClaimClearingHouse")
    private String claimClearingHouse;

    @Column(name = "ClaimPayer")
    private String claimPayer;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Payer{" + "payerId=" + payerId + ", payerName=" + payerName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", payerCode=" + payerCode + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", landLineExtension=" + landLineExtension + ", landLine1=" + landLine1 + ", landLine2=" + landLine2 + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", defaultRate=" + defaultRate + ", identification=" + identification + ", insuranceType=" + insuranceType + ", claimOfficeNumber=" + claimOfficeNumber + ", claimType=" + claimType + ", submissionType=" + submissionType + ", payerRemark=" + payerRemark + ", eligibilityClearingHouse=" + eligibilityClearingHouse + ", eligibilityPayer=" + eligibilityPayer + ", claimClearingHouse=" + claimClearingHouse + ", claimPayer=" + claimPayer + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
