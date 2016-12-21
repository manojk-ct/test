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

/**
 * @author ManojK
 */

@Entity
@Table(name = "Radiologist")
public class Radiologist{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RadiologistId")
    private int radiologistId;
      
    @Column(name = "FirstName",length = 35)
    private String firstName;
    
    @Column(name = "MiddleName",length = 35)
    private String middleName;
    
    @Column(name = "LastName",length = 35)
    private String lastName;
    
    @Column(name = "Degree",length = 35)
    private String degree;
    
    @Column(name = "TaxanomyCode",length = 50)
    private String taxanomyCode;
    
    @Column(name = "NPI")
    private long npi;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "RadiologyGroupId",unique = false,insertable = true,updatable = true,nullable = true)
    private RadiologyGroup radiologyGroup;
    
    @Column(name = "StateLicenceNumber",length = 50)
    private String stateLicenceNumber;
    
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
    
    @Column(name = "PostalCode")
    private long postalCode; 
            
    @Column(name = "PhoneExtension")
    private long phoneExtension;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "Mobile")
    private long mobileNumber;
    
    @Column(name = "EmailAddress")
    private String emailId;
    
    @Column(name = "FaxNumber",length = 35)
    private String faxNumber;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  
    
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

    public RadiologyGroup getRadiologyGroup() {
        return radiologyGroup;
    }

    public void setRadiologyGroup(RadiologyGroup radiologyGroup) {
        this.radiologyGroup = radiologyGroup;
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

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Radiologist{" + "radiologistId=" + radiologistId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", degree=" + degree + ", taxanomyCode=" + taxanomyCode + ", npi=" + npi + ", radiologyGroup=" + radiologyGroup + ", stateLicenceNumber=" + stateLicenceNumber + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", phoneExtension=" + phoneExtension + ", phone=" + phone + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", faxNumber=" + faxNumber + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
    
}