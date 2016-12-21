/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "Facilities")
public class Facilities{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FacilityId")
    private int facilityId;

    @Column(name = "FacilityName")
    private String facilityName;

    @Column(name = "FacilityNPI")
    private long facilityNpi;

    @Column(name = "TaxId")
    private String taxId;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @Column(name = "PosCode")
    private String posCode;

    @Column(name = "CliaNo")
    private int cliaNo;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "DispatchRegionId")
    private DispatchRegions dispatchRegion;
   
    @Column(name = "ServiceAddressLine1")
    private String serviceAddressLine1;

    @Column(name = "ServiceAddressLine2")
    private String serviceAddressLine2;

    @Column(name = "ServiceCity")
    private String serviceCity;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "ServiceStateId")
    private States serviceState;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "ServiceCountryId")
    private Country serviceCountry;
    
    @Column(name = "ServiceZipCode")
    private long serviceZipCode;

    @Column(name = "ServiceWorkPhone")
    private long serviceWorkPhone;

    @Column(name = "ServiceLandLineExtension")
    private long serviceLandLineExtension;

    @Column(name = "ServiceLandLine1")
    private String serviceLandLine1;

    @Column(name = "ServiceLandLine2")
    private String serviceLandLine2;

    @Column(name = "ServiceEmailId")
    private String serviceEmailId;

    @Column(name = "ServiceFaxNumber1")
    private String serviceFaxNumber1;

    @Column(name = "ServiceFaxNumber2")
    private String serviceFaxNumber2;

    @Column(name = "IsBillingLocation")
    private boolean isBillingLocation;

    @Column(name = "BillingAddressLine1")
    private String billingAddressLine1;

    @Column(name = "BillingAddressLine2")
    private String billingAddressLine2;

    @Column(name = "BillingCity")
    private String billingCity;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "BillingStateId")
    private States billingState;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "BillingCountryId")
    private Country billingCountry;
   
    @Column(name = "BillingZipCode")
    private long billingZipCode;

    @Column(name = "BillingWorkPhone")
    private long billingWorkPhone;
    
    @Column(name = "BillingLandLineExtension")
    private long billingLandLineExtension;

    @Column(name = "BillingLandLine1")
    private String billingLandLine1;

    @Column(name = "BillingLandLine2")
    private String billingLandLine2;

    @Column(name = "BillingEmailId")
    private String billingEmailId;

    @Column(name = "BillingFaxNumber1")
    private String billingFaxNumber1;

    @Column(name = "BillingFaxNumber2")
    private String billingFaxNumber2;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "facilityId", nullable = false)
    private Set<Facility_Contacts> contacts;
    
    @Column(name = "AdministratorFirstName")
    private String administratorFirstName;

    @Column(name = "AdministratorLastName")
    private String administratorLastName;
    
    @Column(name = "AdministratorLandLineExtension")
    private long administratorLandLineExtension;

    @Column(name = "AdministratorLandLine1")
    private String administratorLandLine1;

    @Column(name = "AdministratorLandLine2")
    private String administratorLandLine2;

    @Column(name = "AdministratorMobile")
    private long administratorMobile;

    @Column(name = "AdministratorEmailId")
    private String administratorEmailId;

    @Column(name = "AssistantAdministratorFirstName")
    private String assistantAdministratorFirstName;

    @Column(name = "AssistantAdministratorLastName")
    private String assistantAdministratorLastName;

    @Column(name = "AssistantAdministratorLandLineExtension")
    private long assistantAdministratorLandLineExtension;
    
    @Column(name = "AssistantAdministratorLandLine1")
    private String assistantAdministratorLandLine1;

    @Column(name = "AssistantAdministratorLandLine2")
    private String assistantAdministratorLandLine2;

    @Column(name = "AssistantAdministratorMobile")
    private long assistantAdministratorMobile;

    @Column(name = "AssistantAdministratorEmailId")
    private String assistantAdministratorEmailId;

    @Column(name = "DirectorNursingFirstName")
    private String directorNursingFirstName;

    @Column(name = "DirectorNursingLastName")
    private String directorNursingLastName;

    @Column(name = "DirectorNursingLandLineExtension")
    private long directorNursingLandLineExtension;

    @Column(name = "DirectorNursingLandLine1")
    private String directorNursingLandLine1;

    @Column(name = "DirectorNursingLandLine2")
    private String directorNursingLandLine2;

    @Column(name = "DirectorNursingMobile")
    private long directorNursingMobile;

    @Column(name = "DirectorNursingEmailId")
    private String directorNursingEmailId;

    @Column(name = "AssistantDirectorNursingFirstName")
    private String assistantDirectorNursingFirstName;

    @Column(name = "AssistantDirectorNursingLastName")
    private String assistantDirectorNursingLastName;

    @Column(name = "AssistantDirectorNursingLandLineExtension")
    private long assistantDirectorNursingLandLineExtension;

    @Column(name = "AssistantDirectorNursingLandLine1")
    private String assistantDirectorNursingLandLine1;

    @Column(name = "AssistantDirectorNursingLandLine2")
    private String assistantDirectorNursingLandLine2;

    @Column(name = "AssistantDirectorNursingMobile")
    private long assistantDirectorNursingMobile;

    @Column(name = "AssistantDirectorNursingEmailId")
    private String assistantDirectorNursingEmailId;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

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

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public long getFacilityNpi() {
        return facilityNpi;
    }

    public void setFacilityNpi(long facilityNpi) {
        this.facilityNpi = facilityNpi;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public int getCliaNo() {
        return cliaNo;
    }

    public void setCliaNo(int cliaNo) {
        this.cliaNo = cliaNo;
    }

    public String getServiceAddressLine1() {
        return serviceAddressLine1;
    }

    public void setServiceAddressLine1(String serviceAddressLine1) {
        this.serviceAddressLine1 = serviceAddressLine1;
    }

    public String getServiceAddressLine2() {
        return serviceAddressLine2;
    }

    public void setServiceAddressLine2(String serviceAddressLine2) {
        this.serviceAddressLine2 = serviceAddressLine2;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public DispatchRegions getDispatchRegion() {
        return dispatchRegion;
    }

    public void setDispatchRegion(DispatchRegions dispatchRegion) {
        this.dispatchRegion = dispatchRegion;
    }

    public States getServiceState() {
        return serviceState;
    }

    public void setServiceState(States serviceState) {
        this.serviceState = serviceState;
    }

    public Country getServiceCountry() {
        return serviceCountry;
    }

    public void setServiceCountry(Country serviceCountry) {
        this.serviceCountry = serviceCountry;
    }

    public States getBillingState() {
        return billingState;
    }

    public void setBillingState(States billingState) {
        this.billingState = billingState;
    }

    public Country getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(Country billingCountry) {
        this.billingCountry = billingCountry;
    }

    public long getServiceZipCode() {
        return serviceZipCode;
    }

    public void setServiceZipCode(long serviceZipCode) {
        this.serviceZipCode = serviceZipCode;
    }

    public long getServiceWorkPhone() {
        return serviceWorkPhone;
    }

    public void setServiceWorkPhone(long serviceWorkPhone) {
        this.serviceWorkPhone = serviceWorkPhone;
    }

    public long getServiceLandLineExtension() {
        return serviceLandLineExtension;
    }

    public void setServiceLandLineExtension(long serviceLandLineExtension) {
        this.serviceLandLineExtension = serviceLandLineExtension;
    }

    public String getServiceLandLine1() {
        return serviceLandLine1;
    }

    public void setServiceLandLine1(String serviceLandLine1) {
        this.serviceLandLine1 = serviceLandLine1;
    }

    public String getServiceEmailId() {
        return serviceEmailId;
    }

    public void setServiceEmailId(String serviceEmailId) {
        this.serviceEmailId = serviceEmailId;
    }

    public String getServiceFaxNumber1() {
        return serviceFaxNumber1;
    }

    public void setServiceFaxNumber1(String serviceFaxNumber1) {
        this.serviceFaxNumber1 = serviceFaxNumber1;
    }

    public String getServiceFaxNumber2() {
        return serviceFaxNumber2;
    }

    public void setServiceFaxNumber2(String serviceFaxNumber2) {
        this.serviceFaxNumber2 = serviceFaxNumber2;
    }

    public boolean isIsBillingLocation() {
        return isBillingLocation;
    }

    public void setIsBillingLocation(boolean isBillingLocation) {
        this.isBillingLocation = isBillingLocation;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingAddressLine2() {
        return billingAddressLine2;
    }

    public void setBillingAddressLine2(String billingAddressLine2) {
        this.billingAddressLine2 = billingAddressLine2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public long getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(long billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public long getBillingWorkPhone() {
        return billingWorkPhone;
    }

    public void setBillingWorkPhone(long billingWorkPhone) {
        this.billingWorkPhone = billingWorkPhone;
    }

    public String getServiceLandLine2() {
        return serviceLandLine2;
    }
    
    public void setServiceLandLine2(String serviceLandLine2) {
        this.serviceLandLine2 = serviceLandLine2;
    }

    public long getBillingLandLineExtension() {
        return billingLandLineExtension;
    }

    public void setBillingLandLineExtension(long billingLandLineExtension) {
        this.billingLandLineExtension = billingLandLineExtension;
    }

    public String getBillingLandLine1() {
        return billingLandLine1;
    }

    public void setBillingLandLine1(String billingLandLine1) {
        this.billingLandLine1 = billingLandLine1;
    }

    public String getBillingLandLine2() {
        return billingLandLine2;
    }

    public void setBillingLandLine2(String billingLandLine2) {
        this.billingLandLine2 = billingLandLine2;
    }

    public String getBillingEmailId() {
        return billingEmailId;
    }

    public void setBillingEmailId(String billingEmailId) {
        this.billingEmailId = billingEmailId;
    }

    public String getBillingFaxNumber1() {
        return billingFaxNumber1;
    }

    public void setBillingFaxNumber1(String billingFaxNumber1) {
        this.billingFaxNumber1 = billingFaxNumber1;
    }

    public String getBillingFaxNumber2() {
        return billingFaxNumber2;
    }

    public void setBillingFaxNumber2(String billingFaxNumber2) {
        this.billingFaxNumber2 = billingFaxNumber2;
    }

    public Set<Facility_Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Facility_Contacts> contacts) {
        this.contacts = contacts;
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

    public long getAdministratorMobile() {
        return administratorMobile;
    }

    public void setAdministratorMobile(long administratorMobile) {
        this.administratorMobile = administratorMobile;
    }

    public String getAdministratorEmailId() {
        return administratorEmailId;
    }

    public void setAdministratorEmailId(String administratorEmailId) {
        this.administratorEmailId = administratorEmailId;
    }

    public String getAssistantAdministratorFirstName() {
        return assistantAdministratorFirstName;
    }

    public void setAssistantAdministratorFirstName(String assistantAdministratorFirstName) {
        this.assistantAdministratorFirstName = assistantAdministratorFirstName;
    }

    public String getAssistantAdministratorLastName() {
        return assistantAdministratorLastName;
    }

    public void setAssistantAdministratorLastName(String assistantAdministratorLastName) {
        this.assistantAdministratorLastName = assistantAdministratorLastName;
    }

    public long getAssistantAdministratorMobile() {
        return assistantAdministratorMobile;
    }

    public void setAssistantAdministratorMobile(long assistantAdministratorMobile) {
        this.assistantAdministratorMobile = assistantAdministratorMobile;
    }

    public String getAssistantAdministratorEmailId() {
        return assistantAdministratorEmailId;
    }

    public void setAssistantAdministratorEmailId(String assistantAdministratorEmailId) {
        this.assistantAdministratorEmailId = assistantAdministratorEmailId;
    }

    public String getDirectorNursingFirstName() {
        return directorNursingFirstName;
    }

    public void setDirectorNursingFirstName(String directorNursingFirstName) {
        this.directorNursingFirstName = directorNursingFirstName;
    }

    public String getDirectorNursingLastName() {
        return directorNursingLastName;
    }

    public void setDirectorNursingLastName(String directorNursingLastName) {
        this.directorNursingLastName = directorNursingLastName;
    }

    public long getDirectorNursingMobile() {
        return directorNursingMobile;
    }

    public void setDirectorNursingMobile(long directorNursingMobile) {
        this.directorNursingMobile = directorNursingMobile;
    }

    public String getDirectorNursingEmailId() {
        return directorNursingEmailId;
    }

    public void setDirectorNursingEmailId(String directorNursingEmailId) {
        this.directorNursingEmailId = directorNursingEmailId;
    }

    public String getAssistantDirectorNursingFirstName() {
        return assistantDirectorNursingFirstName;
    }

    public void setAssistantDirectorNursingFirstName(String assistantDirectorNursingFirstName) {
        this.assistantDirectorNursingFirstName = assistantDirectorNursingFirstName;
    }

    public String getAssistantDirectorNursingLastName() {
        return assistantDirectorNursingLastName;
    }

    public void setAssistantDirectorNursingLastName(String assistantDirectorNursingLastName) {
        this.assistantDirectorNursingLastName = assistantDirectorNursingLastName;
    }

    public long getAssistantDirectorNursingMobile() {
        return assistantDirectorNursingMobile;
    }

    public void setAssistantDirectorNursingMobile(long assistantDirectorNursingMobile) {
        this.assistantDirectorNursingMobile = assistantDirectorNursingMobile;
    }

    public String getAssistantDirectorNursingEmailId() {
        return assistantDirectorNursingEmailId;
    }

    public void setAssistantDirectorNursingEmailId(String assistantDirectorNursingEmailId) {
        this.assistantDirectorNursingEmailId = assistantDirectorNursingEmailId;
    }

    public long getAdministratorLandLineExtension() {
        return administratorLandLineExtension;
    }

    public void setAdministratorLandLineExtension(long administratorLandLineExtension) {
        this.administratorLandLineExtension = administratorLandLineExtension;
    }

    public String getAdministratorLandLine1() {
        return administratorLandLine1;
    }

    public void setAdministratorLandLine1(String administratorLandLine1) {
        this.administratorLandLine1 = administratorLandLine1;
    }

    public String getAdministratorLandLine2() {
        return administratorLandLine2;
    }

    public void setAdministratorLandLine2(String administratorLandLine2) {
        this.administratorLandLine2 = administratorLandLine2;
    }

    public long getAssistantAdministratorLandLineExtension() {
        return assistantAdministratorLandLineExtension;
    }

    public void setAssistantAdministratorLandLineExtension(long assistantAdministratorLandLineExtension) {
        this.assistantAdministratorLandLineExtension = assistantAdministratorLandLineExtension;
    }

    public String getAssistantAdministratorLandLine1() {
        return assistantAdministratorLandLine1;
    }

    public void setAssistantAdministratorLandLine1(String assistantAdministratorLandLine1) {
        this.assistantAdministratorLandLine1 = assistantAdministratorLandLine1;
    }

    public String getAssistantAdministratorLandLine2() {
        return assistantAdministratorLandLine2;
    }

    public void setAssistantAdministratorLandLine2(String assistantAdministratorLandLine2) {
        this.assistantAdministratorLandLine2 = assistantAdministratorLandLine2;
    }

    public long getDirectorNursingLandLineExtension() {
        return directorNursingLandLineExtension;
    }

    public void setDirectorNursingLandLineExtension(long directorNursingLandLineExtension) {
        this.directorNursingLandLineExtension = directorNursingLandLineExtension;
    }

    public String getDirectorNursingLandLine1() {
        return directorNursingLandLine1;
    }

    public void setDirectorNursingLandLine1(String directorNursingLandLine1) {
        this.directorNursingLandLine1 = directorNursingLandLine1;
    }

    public String getDirectorNursingLandLine2() {
        return directorNursingLandLine2;
    }

    public void setDirectorNursingLandLine2(String directorNursingLandLine2) {
        this.directorNursingLandLine2 = directorNursingLandLine2;
    }

    public long getAssistantDirectorNursingLandLineExtension() {
        return assistantDirectorNursingLandLineExtension;
    }

    public void setAssistantDirectorNursingLandLineExtension(long assistantDirectorNursingLandLineExtension) {
        this.assistantDirectorNursingLandLineExtension = assistantDirectorNursingLandLineExtension;
    }

    public String getAssistantDirectorNursingLandLine1() {
        return assistantDirectorNursingLandLine1;
    }

    public void setAssistantDirectorNursingLandLine1(String assistantDirectorNursingLandLine1) {
        this.assistantDirectorNursingLandLine1 = assistantDirectorNursingLandLine1;
    }

    public String getAssistantDirectorNursingLandLine2() {
        return assistantDirectorNursingLandLine2;
    }

    public void setAssistantDirectorNursingLandLine2(String assistantDirectorNursingLandLine2) {
        this.assistantDirectorNursingLandLine2 = assistantDirectorNursingLandLine2;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Facilities{" + "facilityId=" + facilityId + ", facilityName=" + facilityName + ", facilityNpi=" + facilityNpi + ", taxId=" + taxId + ", isDeleted=" + isDeleted + ", posCode=" + posCode + ", cliaNo=" + cliaNo + ", dispatchRegion=" + dispatchRegion + ", serviceAddressLine1=" + serviceAddressLine1 + ", serviceAddressLine2=" + serviceAddressLine2 + ", serviceCity=" + serviceCity + ", serviceState=" + serviceState + ", serviceCountry=" + serviceCountry + ", serviceZipCode=" + serviceZipCode + ", serviceWorkPhone=" + serviceWorkPhone + ", serviceLandLineExtension=" + serviceLandLineExtension + ", serviceLandLine1=" + serviceLandLine1 + ", serviceLandLine2=" + serviceLandLine2 + ", serviceEmailId=" + serviceEmailId + ", serviceFaxNumber1=" + serviceFaxNumber1 + ", serviceFaxNumber2=" + serviceFaxNumber2 + ", isBillingLocation=" + isBillingLocation + ", billingAddressLine1=" + billingAddressLine1 + ", billingAddressLine2=" + billingAddressLine2 + ", billingCity=" + billingCity + ", billingState=" + billingState + ", billingCountry=" + billingCountry + ", billingZipCode=" + billingZipCode + ", billingWorkPhone=" + billingWorkPhone + ", billingLandLineExtension=" + billingLandLineExtension + ", billingLandLine1=" + billingLandLine1 + ", billingLandLine2=" + billingLandLine2 + ", billingEmailId=" + billingEmailId + ", billingFaxNumber1=" + billingFaxNumber1 + ", billingFaxNumber2=" + billingFaxNumber2 + ", contacts=" + contacts + ", administratorFirstName=" + administratorFirstName + ", administratorLastName=" + administratorLastName + ", administratorLandLineExtension=" + administratorLandLineExtension + ", administratorLandLine1=" + administratorLandLine1 + ", administratorLandLine2=" + administratorLandLine2 + ", administratorMobile=" + administratorMobile + ", administratorEmailId=" + administratorEmailId + ", assistantAdministratorFirstName=" + assistantAdministratorFirstName + ", assistantAdministratorLastName=" + assistantAdministratorLastName + ", assistantAdministratorLandLineExtension=" + assistantAdministratorLandLineExtension + ", assistantAdministratorLandLine1=" + assistantAdministratorLandLine1 + ", assistantAdministratorLandLine2=" + assistantAdministratorLandLine2 + ", assistantAdministratorMobile=" + assistantAdministratorMobile + ", assistantAdministratorEmailId=" + assistantAdministratorEmailId + ", directorNursingFirstName=" + directorNursingFirstName + ", directorNursingLastName=" + directorNursingLastName + ", directorNursingLandLineExtension=" + directorNursingLandLineExtension + ", directorNursingLandLine1=" + directorNursingLandLine1 + ", directorNursingLandLine2=" + directorNursingLandLine2 + ", directorNursingMobile=" + directorNursingMobile + ", directorNursingEmailId=" + directorNursingEmailId + ", assistantDirectorNursingFirstName=" + assistantDirectorNursingFirstName + ", assistantDirectorNursingLastName=" + assistantDirectorNursingLastName + ", assistantDirectorNursingLandLineExtension=" + assistantDirectorNursingLandLineExtension + ", assistantDirectorNursingLandLine1=" + assistantDirectorNursingLandLine1 + ", assistantDirectorNursingLandLine2=" + assistantDirectorNursingLandLine2 + ", assistantDirectorNursingMobile=" + assistantDirectorNursingMobile + ", assistantDirectorNursingEmailId=" + assistantDirectorNursingEmailId + ", commonComponent=" + commonComponent + '}';
    }

    
}
