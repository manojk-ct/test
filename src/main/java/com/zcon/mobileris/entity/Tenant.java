package com.zcon.mobileris.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "Tenant")
public class Tenant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TenantId")
    private int tenantId;

    @Column(name = "TenantName")
    private String tenantName;

    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "City")
    private String city;
 
   // @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "ServiceStartDate")
    private Date serviceStartDate;

    @Column(name = "TenantCode")
    private String tenantCode;

    @Column(name = "AddressLine2")
    private String addressLine2;

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

//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "ServiceValidUpto")
    private Date serviceValidUpto;

    @Column(name = "PhoneExtension")
    private long phoneExtension;
     
    @Column(name = "Phone1")
    private String phone1;

    @Column(name = "MobileNumber")
    private long mobileNumber;

    @Column(name = "FaxNumber")
    private String faxNumber;

    @Column(name = "Phone2")
    private String phone2;

    @Column(name = "EmailId")
    private String emailId;
    
    @Column(name = "Status")
    private String status;

    @Column(name = "OwnerFirstName")
    private String ownerFirstName;

    @Column(name = "OwnerLastName")
    private String ownerLastName;

    @Column(name = "OwnerPhoneExtension")
    private long ownerPhoneExtension;
    
    @Column(name = "OwnerPhone1")
    private String ownerPhone1;

    @Column(name = "OwnerPhone2")
    private String ownerPhone2;

    @Column(name = "OwnerMobileNumber")
    private long ownerMobileNumber;

    @Column(name = "OwnerEmailId")
    private String ownerEmailId;

    @Column(name = "AdministratorFirstName")
    private String administratorFirstName;

    @Column(name = "AdministratorLastName")
    private String administratorLastName;

    @Column(name = "AdministratorPhoneExtension")
    private long administratorPhoneExtension;
    
    @Column(name = "AdministratorPhone1")
    private String administratorPhone1;

    @Column(name = "AdministratorPhone2")
    private String administratorPhone2;

    @Column(name = "AdministratorMobileNumber")
    private long administratorMobileNumber;

    @Column(name = "AdministratorEmailId")
    private String administratorEmailId;

    @Column(name = "SupervisorFirstName")
    private String supervisorFirstName;

    @Column(name = "SupervisorLastName")
    private String supervisorLastName;

    @Column(name = "SupervisorPhoneExtension")
    private long supervisorPhoneExtension;

    @Column(name = "SupervisorPhone1")
    private String supervisorPhone1;

    @Column(name = "SupervisorPhone2")
    private String supervisorPhone2;

    @Column(name = "SupervisorMobileNumber")
    private long supervisorMobileNumber;

    @Column(name = "SupervisorEmailId")
    private String supervisorEmailId;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
//    @OneToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @Cascade(CascadeType.SAVE_UPDATE)
//    @Column(name = "TenantId")
//    private Set<Branches> branches;

    @Embedded
    private AbstractCommonEntity commonComponent; 
    
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

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

    public Date getServiceValidUpto() {
        return serviceValidUpto;
    }

    public void setServiceValidUpto(Date serviceValidUpto) {
        this.serviceValidUpto = serviceValidUpto;
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

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
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

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Tenant{" + "tenantId=" + tenantId + ", tenantName=" + tenantName + ", addressLine1=" + addressLine1 + ", city=" + city + ", serviceStartDate=" + serviceStartDate + ", tenantCode=" + tenantCode + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", serviceValidUpto=" + serviceValidUpto + ", phoneExtension=" + phoneExtension + ", phone1=" + phone1 + ", mobileNumber=" + mobileNumber + ", faxNumber=" + faxNumber + ", phone2=" + phone2 + ", emailId=" + emailId + ", status=" + status + ", ownerFirstName=" + ownerFirstName + ", ownerLastName=" + ownerLastName + ", ownerPhoneExtension=" + ownerPhoneExtension + ", ownerPhone1=" + ownerPhone1 + ", ownerPhone2=" + ownerPhone2 + ", ownerMobileNumber=" + ownerMobileNumber + ", ownerEmailId=" + ownerEmailId + ", administratorFirstName=" + administratorFirstName + ", administratorLastName=" + administratorLastName + ", administratorPhoneExtension=" + administratorPhoneExtension + ", administratorPhone1=" + administratorPhone1 + ", administratorPhone2=" + administratorPhone2 + ", administratorMobileNumber=" + administratorMobileNumber + ", administratorEmailId=" + administratorEmailId + ", supervisorFirstName=" + supervisorFirstName + ", supervisorLastName=" + supervisorLastName + ", supervisorPhoneExtension=" + supervisorPhoneExtension + ", supervisorPhone1=" + supervisorPhone1 + ", supervisorPhone2=" + supervisorPhone2 + ", supervisorMobileNumber=" + supervisorMobileNumber + ", supervisorEmailId=" + supervisorEmailId + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
