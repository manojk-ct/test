package com.zcon.mobileris.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

/**
 * @author PradnyaS
 */
@Entity
@Table(name = "Provider")
public class Provider{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProviderId")
    private int providerId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Degree")
    private String degree;

    @Column(name = "TaxanomyCode")
    private String taxanomyCode;

    @Column(name = "NPI")
    private long npi;

    @Column(name = "PECOSEnrolled")
    private boolean pecosEnrolled;

    @Column(name = "OrderingStatus")
    private String orderingStatus;

    @Column(name = "ProviderType")
    private String providerType;

    @Column(name = "JobDescription")
    private String jobDescription;

    @Column(name = "FederalTaxID")
    private String federalTaxId;

    @Column(name = "FederalDrugID")
    private String federalDrugId;

    @Column(name = "StateLicenseNumber")
    private long stateLicenseNumber;

    @Column(name = "NewCorpeRXRole")
    private String newcorperxRole;

    @Column(name = "SeeAuthorization")
    private boolean seeAuthorization;

    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "AddressLine2")
    private String addressLine2;

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

    @Column(name = "PhoneExtension")
    private long phoneExtension;
    
    @Column(name = "Phone1")
    private String phone1;

    @Column(name = "Phone2")
    private String phone2;

    @Column(name = "MobileNumber")
    private long mobileNumber;

    @Column(name = "EmailID")
    private String emailId;

    @Column(name = "FaxNumber")
    private long faxNumber;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "FacilityId")
    private Facilities facility;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    @JsonIgnore
    @JsonProperty(value = "facility")    
    public Facilities getFacility() {
        return facility;
    }
    
    @JsonIgnore
    public void setFacility(Facilities facility) {
        this.facility = facility;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
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

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Provider{" + "providerId=" + providerId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", degree=" + degree + ", taxanomyCode=" + taxanomyCode + ", npi=" + npi + ", pecosEnrolled=" + pecosEnrolled + ", orderingStatus=" + orderingStatus + ", providerType=" + providerType + ", jobDescription=" + jobDescription + ", federalTaxId=" + federalTaxId + ", federalDrugId=" + federalDrugId + ", stateLicenseNumber=" + stateLicenseNumber + ", newcorperxRole=" + newcorperxRole + ", seeAuthorization=" + seeAuthorization + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", phoneExtension=" + phoneExtension + ", phone1=" + phone1 + ", phone2=" + phone2 + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", isDeleted=" + isDeleted + ", facility=" + facility + ", commonComponent=" + commonComponent + '}';
    }

}
