/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author MayuriM
 */
public class TechnologistDTO implements Serializable{
    private int technologistId;
    private int addressStateId;
    private int addressCountryId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String technologistCode;
    private String aliase;
    private String gender;
    private Boolean isMarried;
    private Date dateofBirth;
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressZip;
    private String homePhone;
    private String mobilePhone;
    private String officePhone;
    private String otherPhone;
    private String email;
    private String fax;
    private String ssn;
    private Date dateOfJoining;
    private String pager;
    private int affilatedById;
    private String technologistTypeListValueId;
    private String licenseNo;
    private Date licenseIssueDate;
    private Date licenseExpiryDate;
    private String degree;
    private String schoolAttended;
    private int experience;
    private String lastEmployedBy;
    private String otherSpecilities;
    private String emergencyPhone2;
    private String emergencyContact;
    private String relationship;
    private String otherRestrictions;
    private String ethincity;
    private String emergencyPhone1;
    private String lincenceUID;
    private int age;
    private boolean isDeleted;
    private Set<TechnologistSpecialitiesDTO> technologistSpecialityObject;
    private Set<TechnologistAvailabilityDTO> technologistAvailabilityObject;
    private Set<TechnologistTechniquesDTO> technologistTechniqueObject;

    public int getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(int technologistId) {
        this.technologistId = technologistId;
    }

    public int getAddressStateId() {
        return addressStateId;
    }

    public void setAddressStateId(int addressStateId) {
        this.addressStateId = addressStateId;
    }

    public int getAddressCountryId() {
        return addressCountryId;
    }

    public void setAddressCountryId(int addressCountryId) {
        this.addressCountryId = addressCountryId;
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

    public Set<TechnologistSpecialitiesDTO> getTechnologistSpecialityObject() {
        return technologistSpecialityObject;
    }

    public void setTechnologistSpecialityObject(Set<TechnologistSpecialitiesDTO> technologistSpecialityObject) {
        this.technologistSpecialityObject = technologistSpecialityObject;
    }

    public Set<TechnologistAvailabilityDTO> getTechnologistAvailabilityObject() {
        return technologistAvailabilityObject;
    }

    public void setTechnologistAvailabilityObject(Set<TechnologistAvailabilityDTO> technologistAvailabilityObject) {
        this.technologistAvailabilityObject = technologistAvailabilityObject;
    }

    public Set<TechnologistTechniquesDTO> getTechnologistTechniqueObject() {
        return technologistTechniqueObject;
    }

    public void setTechnologistTechniqueObject(Set<TechnologistTechniquesDTO> technologistTechniqueObject) {
        this.technologistTechniqueObject = technologistTechniqueObject;
    }

    @Override
    public String toString() {
        return "TechnologistDTO{" + "technologistId=" + technologistId + ", addressStateId=" + addressStateId + ", addressCountryId=" + addressCountryId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", technologistCode=" + technologistCode + ", aliase=" + aliase + ", gender=" + gender + ", isMarried=" + isMarried + ", dateofBirth=" + dateofBirth + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressCity=" + addressCity + ", addressZip=" + addressZip + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", officePhone=" + officePhone + ", otherPhone=" + otherPhone + ", email=" + email + ", fax=" + fax + ", ssn=" + ssn + ", dateOfJoining=" + dateOfJoining + ", pager=" + pager + ", affilatedById=" + affilatedById + ", technologistTypeListValueId=" + technologistTypeListValueId + ", licenseNo=" + licenseNo + ", licenseIssueDate=" + licenseIssueDate + ", licenseExpiryDate=" + licenseExpiryDate + ", degree=" + degree + ", schoolAttended=" + schoolAttended + ", experience=" + experience + ", lastEmployedBy=" + lastEmployedBy + ", otherSpecilities=" + otherSpecilities + ", emergencyPhone2=" + emergencyPhone2 + ", emergencyContact=" + emergencyContact + ", relationship=" + relationship + ", otherRestrictions=" + otherRestrictions + ", ethincity=" + ethincity + ", emergencyPhone1=" + emergencyPhone1 + ", lincenceUID=" + lincenceUID + ", age=" + age + ", isDeleted=" + isDeleted + ", technologistSpecialityObject=" + technologistSpecialityObject + ", technologistAvailabilityObject=" + technologistAvailabilityObject + ", technologistTechniqueObject=" + technologistTechniqueObject + '}';
    }
    
    
}
