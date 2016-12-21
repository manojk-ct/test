/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "Technologist")
public class Technologist{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnologistId")
    private int technologistId;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "addressStateId")
    private States stateObject;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "addressCountryId")
    private Country countryObject;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "MiddleName")
    private String middleName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "TechnologistCode")
    private String technologistCode;
    
    @Column(name = "Aliase")
    private String aliase;
    
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "IsMarried")
    private Boolean isMarried;
    
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "DateofBirth")
    private Date dateofBirth;
    
    @Column(name = "AddressLine1")
    private String addressLine1;
    
    @Column(name = "AddressLine2")
    private String addressLine2;
    
    @Column(name = "AddressCity")
    private String addressCity;
    
    @Column(name = "AddressZip")
    private String addressZip;
    
    @Column(name = "HomePhone")
    private String homePhone;
    
    @Column(name = "MobilePhone")
    private String mobilePhone;
        
     @Column(name = "OfficePhone")
    private String officePhone;
    
    @Column(name = "OtherPhone")
    private String otherPhone;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "FAX")
    private String fax;
    
    @Column(name = "SSN")
    private String ssn;
    
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfJoining")
    private Date dateOfJoining;
    
    @Column(name = "Pager")
    private String pager;
    
    @Column(name = "AffilatedById")
    private int affilatedById;
    
    @Column(name = "TechnologistTypeListValueId")
    private String technologistTypeListValueId;
    
    @Column(name = "LicenseNo")
    private String licenseNo;
    
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "LicenseIssueDate")
    private Date licenseIssueDate;
    
  //  @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "LicenseExpiryDate")
    private Date licenseExpiryDate;
    
    @Column(name = "Degree")
    private String degree;
    
    @Column(name = "SchoolAttended")
    private String schoolAttended;
    
    @Column(name = "Experience")
    private int experience;
    
    @Column(name = "LastEmployedBy")
    private String lastEmployedBy;
    
    @Column(name = "OtherSpecilities")
    private String otherSpecilities;
    
    @Column(name = "EmergencyPhone2")
    private String emergencyPhone2;
    
    @Column(name = "EmergencyContact")
    private String emergencyContact;
     
    @Column(name = "Relationship")
    private String relationship;
    
    @Column(name = "OtherRestrictions")
    private String otherRestrictions;
    
    @Column(name = "Ethincity")
    private String ethincity;
    
    @Column(name = "EmergencyPhone1")
    private String emergencyPhone1;
    
    @Column(name = "LincenceUID")
    private String lincenceUID;
    
    @Column(name = "Age")
    private int age;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "technologistId", nullable = false)
    private Set<TechnologistSpecialities> technologistSpecialityObject;
    
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "technologistId", nullable = false)
    private Set<TechnologistAvailability> technologistAvailabilityObject;
    
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "technologistId", nullable = false)
    private Set<TechnologistTechniques> technologistTechniqueObject;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(int technologistId) {
        this.technologistId = technologistId;
    }

    public States getStateObject() {
        return stateObject;
    }

    public void setStateObject(States stateObject) {
        this.stateObject = stateObject;
    }

    public Country getCountryObject() {
        return countryObject;
    }

    public void setCountryObject(Country countryObject) {
        this.countryObject = countryObject;
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

    public String getTechnologistCode() {
        return technologistCode;
    }

    public void setTechnologistCode(String technologistCode) {
        this.technologistCode = technologistCode;
    }

    public String getAliase() {
        return aliase;
    }

    public void setAliase(String aliase) {
        this.aliase = aliase;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
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

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public int getAffilatedById() {
        return affilatedById;
    }

    public void setAffilatedById(int affilatedById) {
        this.affilatedById = affilatedById;
    }

    public String getTechnologistTypeListValueId() {
        return technologistTypeListValueId;
    }

    public void setTechnologistTypeListValueId(String technologistTypeListValueId) {
        this.technologistTypeListValueId = technologistTypeListValueId;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Date getLicenseIssueDate() {
        return licenseIssueDate;
    }

    public void setLicenseIssueDate(Date licenseIssueDate) {
        this.licenseIssueDate = licenseIssueDate;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchoolAttended() {
        return schoolAttended;
    }

    public void setSchoolAttended(String schoolAttended) {
        this.schoolAttended = schoolAttended;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getLastEmployedBy() {
        return lastEmployedBy;
    }

    public void setLastEmployedBy(String lastEmployedBy) {
        this.lastEmployedBy = lastEmployedBy;
    }

    public String getOtherSpecilities() {
        return otherSpecilities;
    }

    public void setOtherSpecilities(String otherSpecilities) {
        this.otherSpecilities = otherSpecilities;
    }

    public String getEmergencyPhone2() {
        return emergencyPhone2;
    }

    public void setEmergencyPhone2(String emergencyPhone2) {
        this.emergencyPhone2 = emergencyPhone2;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getOtherRestrictions() {
        return otherRestrictions;
    }

    public void setOtherRestrictions(String otherRestrictions) {
        this.otherRestrictions = otherRestrictions;
    }

    public String getEthincity() {
        return ethincity;
    }

    public void setEthincity(String ethincity) {
        this.ethincity = ethincity;
    }

    public String getEmergencyPhone1() {
        return emergencyPhone1;
    }

    public void setEmergencyPhone1(String emergencyPhone1) {
        this.emergencyPhone1 = emergencyPhone1;
    }

    public String getLincenceUID() {
        return lincenceUID;
    }

    public void setLincenceUID(String lincenceUID) {
        this.lincenceUID = lincenceUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<TechnologistSpecialities> getTechnologistSpecialityObject() {
        return technologistSpecialityObject;
    }

    public void setTechnologistSpecialityObject(Set<TechnologistSpecialities> technologistSpecialityObject) {
        this.technologistSpecialityObject = technologistSpecialityObject;
    }

    public Set<TechnologistAvailability> getTechnologistAvailabilityObject() {
        return technologistAvailabilityObject;
    }

    public void setTechnologistAvailabilityObject(Set<TechnologistAvailability> technologistAvailabilityObject) {
        this.technologistAvailabilityObject = technologistAvailabilityObject;
    }

    public Set<TechnologistTechniques> getTechnologistTechniqueObject() {
        return technologistTechniqueObject;
    }

    public void setTechnologistTechniqueObject(Set<TechnologistTechniques> technologistTechniqueObject) {
        this.technologistTechniqueObject = technologistTechniqueObject;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Technologist{" + "technologistId=" + technologistId + ", stateObject=" + stateObject + ", countryObject=" + countryObject + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", technologistCode=" + technologistCode + ", aliase=" + aliase + ", gender=" + gender + ", isMarried=" + isMarried + ", dateofBirth=" + dateofBirth + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressCity=" + addressCity + ", addressZip=" + addressZip + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", officePhone=" + officePhone + ", otherPhone=" + otherPhone + ", email=" + email + ", fax=" + fax + ", ssn=" + ssn + ", dateOfJoining=" + dateOfJoining + ", pager=" + pager + ", affilatedById=" + affilatedById + ", technologistTypeListValueId=" + technologistTypeListValueId + ", licenseNo=" + licenseNo + ", licenseIssueDate=" + licenseIssueDate + ", licenseExpiryDate=" + licenseExpiryDate + ", degree=" + degree + ", schoolAttended=" + schoolAttended + ", experience=" + experience + ", lastEmployedBy=" + lastEmployedBy + ", otherSpecilities=" + otherSpecilities + ", emergencyPhone2=" + emergencyPhone2 + ", emergencyContact=" + emergencyContact + ", relationship=" + relationship + ", otherRestrictions=" + otherRestrictions + ", ethincity=" + ethincity + ", emergencyPhone1=" + emergencyPhone1 + ", lincenceUID=" + lincenceUID + ", age=" + age + ", isDeleted=" + isDeleted + ", technologistSpecialityObject=" + technologistSpecialityObject + ", technologistAvailabilityObject=" + technologistAvailabilityObject + ", technologistTechniqueObject=" + technologistTechniqueObject + ", commonComponent=" + commonComponent + '}';
    }
    
}
