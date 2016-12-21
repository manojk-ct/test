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
@Table(name = "Facility_Contacts")
public class Facility_Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityContactId;

    @Column(name = "ContactType")
    private String contactType;
    
    @Column(name = "ContactPersonName")
    private String contactPersonName;

    @Column(name = "MobileNumber")
    private long mobileNumber;

    @Column(name = "Extension")
    private long extension;
     
    @Column(name = "LandLine")
    private String landLine;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "FaxNumber")
    private String faxNumber;

    @Column(name = "FacilityId", insertable = false, updatable = false)
    private int facilityId;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @Column(name = "IsActive", nullable = false, columnDefinition = "bit(1) default true")
    private boolean isActive;

    @Embedded
    private AbstractCommonEntity commonComponent;  
    
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Facility_Contacts{" + "facilityContactId=" + facilityContactId + ", contactType=" + contactType + ", contactPersonName=" + contactPersonName + ", mobileNumber=" + mobileNumber + ", extension=" + extension + ", landLine=" + landLine + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", facilityId=" + facilityId + ", isDeleted=" + isDeleted + ", isActive=" + isActive + ", commonComponent=" + commonComponent + '}';
    }

    
}
