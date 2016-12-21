/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import com.zcon.mobileris.entity.Patient_Insurance;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PradnyaS
 */
public class PatientDTO implements Serializable {
    private int patientId;
    @NotNull
    @Length(min=1,max = 35)
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date dob;
    private String maritalStatus;
    private String ssn;
    private int age;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private int stateId;
    private int countryId;
    private long zipCode;
    private long landLineExtension;
    private String landLine1;
    private boolean isDeleted;
    private String landLine2;
    @Email
    private String emailId;
    private long faxNumber;
    private String guardianName;
    @Email
    private String trustedEmailId;
    private String notes;
    private Set<Patient_Insurance> insurance;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getTrustedEmailId() {
        return trustedEmailId;
    }

    public void setTrustedEmailId(String trustedEmailId) {
        this.trustedEmailId = trustedEmailId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Patient_Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Set<Patient_Insurance> insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "PatientDTO{" + "patientId=" + patientId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + ", maritalStatus=" + maritalStatus + ", ssn=" + ssn + ", age=" + age + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", stateId=" + stateId + ", countryId=" + countryId + ", zipCode=" + zipCode + ", landLineExtension=" + landLineExtension + ", landLine1=" + landLine1 + ", isDeleted=" + isDeleted + ", landLine2=" + landLine2 + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", guardianName=" + guardianName + ", trustedEmailId=" + trustedEmailId + ", notes=" + notes + ", insurance=" + insurance + '}';
    }

}
