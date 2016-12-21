/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author PradnyaS
 */
public class TenantDTO  implements Serializable{
    @NotNull
    private int tenantId;
    @NotNull
    @Length(min=1,max = 35)
    private String tenantName;
    private String addressLine1;
    private String city;
    private Date serviceStartDate;
    private String tenantCode;
    private String addressLine2;
    @NotNull
    private int countryId;
    @NotNull
    private int stateId;
    private long zipCode;
    private Date serviceValidUpto;
    private long phoneExtension;
    private String phone1;
    private long mobileNumber;
    private String faxNumber;
    private String phone2;
    @Email
    private String emailId;
    private String status;
    private String ownerFirstName;
    private String ownerLastName;
    private long ownerPhoneExtension;
    private String ownerPhone1;
    private String ownerPhone2;
    private long ownerMobileNumber;
    @Email
    private String ownerEmailId;
    private String administratorFirstName;
    private String administratorLastName;
    private long administratorPhoneExtension;
    private String administratorPhone1;
    private String administratorPhone2;
    private long administratorMobileNumber;
    @Email
    private String administratorEmailId;
    private String supervisorFirstName;
    private String supervisorLastName;
    private long supervisorPhoneExtension;
    private String supervisorPhone1;
    private String supervisorPhone2;
    private long supervisorMobileNumber;
    @Email
    private String supervisorEmailId;
    private boolean isDeleted;

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public Date getServiceValidUpto() {
        return serviceValidUpto;
    }

    public void setServiceValidUpto(Date serviceValidUpto) {
        this.serviceValidUpto = serviceValidUpto;
    }

    
    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public long getOwnerMobileNumber() {
        return ownerMobileNumber;
    }

    public void setOwnerMobileNumber(long ownerMobileNumber) {
        this.ownerMobileNumber = ownerMobileNumber;
    }

    public String getOwnerEmailId() {
        return ownerEmailId;
    }

    public void setOwnerEmailId(String ownerEmailId) {
        this.ownerEmailId = ownerEmailId;
    }

    public String getAdministratorFirstName() {
        return administratorFirstName;
    }

    public void setAdministratorFirstName(String administratorFirstName) {
        this.administratorFirstName = administratorFirstName;
    }

    public String getAdministratorLastName() {
        return administratorLastName;
    }

    public void setAdministratorLastName(String administratorLastName) {
        this.administratorLastName = administratorLastName;
    }

    public long getAdministratorMobileNumber() {
        return administratorMobileNumber;
    }

    public void setAdministratorMobileNumber(long administratorMobileNumber) {
        this.administratorMobileNumber = administratorMobileNumber;
    }

    public String getAdministratorEmailId() {
        return administratorEmailId;
    }

    public void setAdministratorEmailId(String administratorEmailId) {
        this.administratorEmailId = administratorEmailId;
    }

    public String getSupervisorFirstName() {
        return supervisorFirstName;
    }

    public void setSupervisorFirstName(String supervisorFirstName) {
        this.supervisorFirstName = supervisorFirstName;
    }

    public String getSupervisorLastName() {
        return supervisorLastName;
    }

    public void setSupervisorLastName(String supervisorLastName) {
        this.supervisorLastName = supervisorLastName;
    }

    public long getSupervisorMobileNumber() {
        return supervisorMobileNumber;
    }

    public void setSupervisorMobileNumber(long supervisorMobileNumber) {
        this.supervisorMobileNumber = supervisorMobileNumber;
    }

    public String getSupervisorEmailId() {
        return supervisorEmailId;
    }

    public void setSupervisorEmailId(String supervisorEmailId) {
        this.supervisorEmailId = supervisorEmailId;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public long getOwnerPhoneExtension() {
        return ownerPhoneExtension;
    }

    public void setOwnerPhoneExtension(long ownerPhoneExtension) {
        this.ownerPhoneExtension = ownerPhoneExtension;
    }

    public String getOwnerPhone1() {
        return ownerPhone1;
    }

    public void setOwnerPhone1(String ownerPhone1) {
        this.ownerPhone1 = ownerPhone1;
    }

    public String getOwnerPhone2() {
        return ownerPhone2;
    }

    public void setOwnerPhone2(String ownerPhone2) {
        this.ownerPhone2 = ownerPhone2;
    }

    public long getAdministratorPhoneExtension() {
        return administratorPhoneExtension;
    }

    public void setAdministratorPhoneExtension(long administratorPhoneExtension) {
        this.administratorPhoneExtension = administratorPhoneExtension;
    }

    public String getAdministratorPhone1() {
        return administratorPhone1;
    }

    public void setAdministratorPhone1(String administratorPhone1) {
        this.administratorPhone1 = administratorPhone1;
    }

    public String getAdministratorPhone2() {
        return administratorPhone2;
    }

    public void setAdministratorPhone2(String administratorPhone2) {
        this.administratorPhone2 = administratorPhone2;
    }

    public long getSupervisorPhoneExtension() {
        return supervisorPhoneExtension;
    }

    public void setSupervisorPhoneExtension(long supervisorPhoneExtension) {
        this.supervisorPhoneExtension = supervisorPhoneExtension;
    }

    public String getSupervisorPhone1() {
        return supervisorPhone1;
    }

    public void setSupervisorPhone1(String supervisorPhone1) {
        this.supervisorPhone1 = supervisorPhone1;
    }

    public String getSupervisorPhone2() {
        return supervisorPhone2;
    }

    public void setSupervisorPhone2(String supervisorPhone2) {
        this.supervisorPhone2 = supervisorPhone2;
    }

    @Override
    public String toString() {
        return "TenantDTO{" + "tenantId=" + tenantId + ", tenantName=" + tenantName + ", addressLine1=" + addressLine1 + ", city=" + city + ", serviceStartDate=" + serviceStartDate + ", tenantCode=" + tenantCode + ", addressLine2=" + addressLine2 + ", countryId=" + countryId + ", stateId=" + stateId + ", zipCode=" + zipCode + ", serviceValidUpto=" + serviceValidUpto + ", phoneExtension=" + phoneExtension + ", phone1=" + phone1 + ", mobileNumber=" + mobileNumber + ", faxNumber=" + faxNumber + ", phone2=" + phone2 + ", emailId=" + emailId + ", status=" + status + ", ownerFirstName=" + ownerFirstName + ", ownerLastName=" + ownerLastName + ", ownerPhoneExtension=" + ownerPhoneExtension + ", ownerPhone1=" + ownerPhone1 + ", ownerPhone2=" + ownerPhone2 + ", ownerMobileNumber=" + ownerMobileNumber + ", ownerEmailId=" + ownerEmailId + ", administratorFirstName=" + administratorFirstName + ", administratorLastName=" + administratorLastName + ", administratorPhoneExtension=" + administratorPhoneExtension + ", administratorPhone1=" + administratorPhone1 + ", administratorPhone2=" + administratorPhone2 + ", administratorMobileNumber=" + administratorMobileNumber + ", administratorEmailId=" + administratorEmailId + ", supervisorFirstName=" + supervisorFirstName + ", supervisorLastName=" + supervisorLastName + ", supervisorPhoneExtension=" + supervisorPhoneExtension + ", supervisorPhone1=" + supervisorPhone1 + ", supervisorPhone2=" + supervisorPhone2 + ", supervisorMobileNumber=" + supervisorMobileNumber + ", supervisorEmailId=" + supervisorEmailId + ", isDeleted=" + isDeleted + '}';
    }
    
}
