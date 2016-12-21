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
public class ProviderDTO implements Serializable {
    @NotNull
    private int providerId;
    @NotNull
    @Length(min=1,max = 35)
    private String firstName;
    private String middleName;
    private String lastName;
    private String degree;
    private String taxanomyCode;
    private long npi;
    private boolean pecosEnrolled;
    private String orderingStatus;
    private String providerType;
    private String jobDescription;
    private String federalTaxId;
    private String federalDrugId;
    private long stateLicenseNumber;
    private String newcorperxRole;
    private boolean seeAuthorization;
    private String addressLine1;
    private String addressLine2;
    private String city;
    @NotNull
    private int stateId;
    @NotNull
    private int countryId;
    private long zipCode;
    private long phoneExtension;
    private String phone1;
    private String phone2;
    private long mobileNumber;
    @Email
    private String emailId;
    private long faxNumber;
    private boolean isDeleted;
    private int facilityId;    

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTaxanomyCode() {
        return taxanomyCode;
    }

    public void setTaxanomyCode(String taxanomyCode) {
        this.taxanomyCode = taxanomyCode;
    }

    public long getNpi() {
        return npi;
    }

    public void setNpi(long npi) {
        this.npi = npi;
    }

    public boolean isPecosEnrolled() {
        return pecosEnrolled;
    }

    public void setPecosEnrolled(boolean pecosEnrolled) {
        this.pecosEnrolled = pecosEnrolled;
    }

    public String getOrderingStatus() {
        return orderingStatus;
    }

    public void setOrderingStatus(String orderingStatus) {
        this.orderingStatus = orderingStatus;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getFederalTaxId() {
        return federalTaxId;
    }

    public void setFederalTaxId(String federalTaxId) {
        this.federalTaxId = federalTaxId;
    }

    public String getFederalDrugId() {
        return federalDrugId;
    }

    public void setFederalDrugId(String federalDrugId) {
        this.federalDrugId = federalDrugId;
    }

    public long getStateLicenseNumber() {
        return stateLicenseNumber;
    }

    public void setStateLicenseNumber(long stateLicenseNumber) {
        this.stateLicenseNumber = stateLicenseNumber;
    }

    public String getNewcorperxRole() {
        return newcorperxRole;
    }

    public void setNewcorperxRole(String newcorperxRole) {
        this.newcorperxRole = newcorperxRole;
    }

    public boolean isSeeAuthorization() {
        return seeAuthorization;
    }

    public void setSeeAuthorization(boolean seeAuthorization) {
        this.seeAuthorization = seeAuthorization;
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

    public long getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(long phoneExtension) {
        this.phoneExtension = phoneExtension;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "ProviderDTO{" + "providerId=" + providerId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", degree=" + degree + ", taxanomyCode=" + taxanomyCode + ", npi=" + npi + ", pecosEnrolled=" + pecosEnrolled + ", orderingStatus=" + orderingStatus + ", providerType=" + providerType + ", jobDescription=" + jobDescription + ", federalTaxId=" + federalTaxId + ", federalDrugId=" + federalDrugId + ", stateLicenseNumber=" + stateLicenseNumber + ", newcorperxRole=" + newcorperxRole + ", seeAuthorization=" + seeAuthorization + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", stateId=" + stateId + ", countryId=" + countryId + ", zipCode=" + zipCode + ", phoneExtension=" + phoneExtension + ", phone1=" + phone1 + ", phone2=" + phone2 + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", isDeleted=" + isDeleted + ", facilityId=" + facilityId + '}';
    }
    
}
