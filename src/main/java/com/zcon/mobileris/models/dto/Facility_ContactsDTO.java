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
public class Facility_ContactsDTO implements Serializable {
    
    private int facilityContactId;
    private String contactType;
    @NotNull
    @Length(min=1,max = 35)
    private String contactPersonName;
    private long mobileNumber;
    private long extension;
    private String landLine;
    @Email
    private String emailId;
    private String faxNumber;
    private int facilityId;
    private boolean isDeleted;
    private boolean isActive;

    public int getFacilityContactId() {
        return facilityContactId;
    }

    public void setFacilityContactId(int facilityContactId) {
        this.facilityContactId = facilityContactId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public long getExtension() {
        return extension;
    }

    public void setExtension(long extension) {
        this.extension = extension;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
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

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Facility_ContactsDTO{" + "facilityContactId=" + facilityContactId + ", contactType=" + contactType + ", contactPersonName=" + contactPersonName + ", mobileNumber=" + mobileNumber + ", extension=" + extension + ", landLine=" + landLine + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", facilityId=" + facilityId + ", isDeleted=" + isDeleted + ", isActive=" + isActive + '}';
    }
   
}
