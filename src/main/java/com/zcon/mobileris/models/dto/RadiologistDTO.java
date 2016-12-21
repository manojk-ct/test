package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ManojK
 */

public class RadiologistDTO implements Serializable{
    private int radiologistId;
    
    @NotNull
    @Length(min=1,max = 35)
    private String firstName;
    
    private String middleName;
    private String lastName;
    private String degree;
    private String taxanomyCode;
    private long npi;
    private String stateLicenceNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    @NotEmpty
    private int stateId;
    @NotEmpty
    private int countryId;
    private long postalCode;
    private long phoneExtension;
    private String phone;    
    private long mobileNumber;
    
    @Email
    private String emailId;
    
    private String faxNumber;
    private int radiologyGroupId;

    public int getRadiologistId() {
        return radiologistId;
    }

    public void setRadiologistId(int radiologistId) {
        this.radiologistId = radiologistId;
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

    public String getStateLicenceNumber() {
        return stateLicenceNumber;
    }

    public void setStateLicenceNumber(String stateLicenceNumber) {
        this.stateLicenceNumber = stateLicenceNumber;
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

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public long getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(long phoneExtension) {
        this.phoneExtension = phoneExtension;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public int getRadiologyGroupId() {
        return radiologyGroupId;
    }

    public void setRadiologyGroupId(int radiologyGroupId) {
        this.radiologyGroupId = radiologyGroupId;
    }

    @Override
    public String toString() {
        return "RadiologistDTO{" + "radiologistId=" + radiologistId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", degree=" + degree + ", taxanomyCode=" + taxanomyCode + ", npi=" + npi + ", stateLicenceNumber=" + stateLicenceNumber + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", stateId=" + stateId + ", countryId=" + countryId + ", postalCode=" + postalCode + ", phoneExtension=" + phoneExtension + ", phone=" + phone + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", radiologyGroupId=" + radiologyGroupId + '}';
    }
    
}
