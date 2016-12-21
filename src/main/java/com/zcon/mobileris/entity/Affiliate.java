/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

import java.sql.Time;
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
 *
 * @author MayuriM
 */
@Entity
@Table(name = "affialiates")
public class Affiliate{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AffialiateId")
    private int affialiateId;

    @Column(name = "CompanyType")
    private String companyType;

    @Column(name = "CompanyId")
    private String companyId;
    
    @Column(name = "ComapnyName")
    private String comapnyName;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "dispatchRegionId")
    private DispatchRegions dispatchRegion;
    
    @Column(name = "Category")
    private String category;
   
    @Column(name = "NPI")
    private int npi;

    @Column(name = "DefaultMedicareLIstValueId")
    private int defaultMedicareLIstValueId;
    
    @Column(name = "DefaultMedicaId")
    private int defaultMedicaId;

    @Column(name = "FedralTaxId")
    private String fedralTaxId;
    
    @Column(name = "FedralDrugsId")
    private String fedralDrugsId;

    @Column(name = "RenderingProvider")
    private String renderingProvider;
    
    @Column(name = "UPIN")
    private String upin;

    @Column(name = "StatTime")
    private java.sql.Time statTime;
    
    @Column(name = "NonStatTime")
    private java.sql.Time nonStatTime;

    @Column(name = "SignOnFile")
    private boolean signOnFile;
    
    @Column(name = "IsPrintBillDate")
    private boolean isPrintBillDate;

    @Column(name = "IsFollowWorkflow")
    private boolean isFollowWorkflow;

    @Column(name = "IsMoreThanTwoTrip")
    private boolean isMoreThanTwoTrip;

    @Column(name = "Charges")
    private double charges;
    
    @Column(name = "FacilityType")
    private String facilityType;

    @Column(name = "Discount")
    private double discount;
    
    @Column(name = "ScheduleType")
    private String ScheduleType;

    @Column(name = "ContactAddressLine1")
    private String contactAddressLine1;
    
    @Column(name = "ContactAddressLine2")
    private String contactAddressLine2;

    @Column(name = "ContactCity")
    private String contactCity;
   
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "contactStateId")
    private States state;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "contactCountryId")
    private Country country;
    
    @Column(name = "ContactZipCode")
    private String contactZipCode;

    @Column(name = "ContactLineLand1")
    private String contactLineLand1;
    
    @Column(name = "MobileNo")
    private String mobileNo;
    
    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "FaxId")
    private String faxId;
    
    @Column(name = "PrimaryBatchCode")
    private String primaryBatchCode;

    @Column(name = "PrimaryBatchNumber")
    private String primaryBatchNumber;
    
    @Column(name = "SecondaryBatchCode")
    private String secondaryBatchCode;

    @Column(name = "SecondaryBatchNumber")
    private String secondaryBatchNumber;
    
    @Column(name = "TeriataryBatchCode")
    private String teriataryBatchCode;

    @Column(name = "TeriataryBatchNumber")
    private String teriataryBatchNumber;
    
    @Column(name = "PatientInvoiceCode")
    private String patientInvoiceCode;
    
    @Column(name = "PatientInvoiceNumber")
    private String patientInvoiceNumber;

    @Column(name = "PSPInvoiceCode")
    private String pspInvoiceCode;
    
    @Column(name = "PPSInvoiceNumber")
    private String ppsInvoiceNumber;

    @Column(name = "PatientPaymentTerm")
    private String patientPaymentTerm;
    
    @Column(name = "ProviderId")
    private String providerId;

    @Column(name = "InsuranceCarryForward")
    private String insuranceCarryForward;
    
    @Column(name = "ClearingHouse")
    private String clearingHouse;

    @Column(name = "Format")
    private String format;
    
    @Column(name = "Form")
    private String form;

    @Column(name = "Clia")
    private String clia;
    
    @Column(name = "ChargeType")
    private String chargeType;

    @Column(name = "ReceiverSymbolicId")
    private String receiverSymbolicId;

    @Column(name = "ReceiverFullName")
    private String receiverFullName;
    
    @Column(name = "SubmitterId")
    private String submitterId;
    
    @Column(name = "SubmitterEntityName")
    private String submitterEntityName;

    @Column(name = "SubmitterFirstName")
    private String submitterFirstName;
    
    @Column(name = "SubmitterMiddleName")
    private String submitterMiddleName;

    @Column(name = "SubmitterLastName")
    private String submitterLastName;

    @Column(name = "SubmitterEmail")
    private String submitterEmail;
    
    @Column(name = "SubmitterPhone")
    private String submitterPhone;
    
    @Column(name = "SubmitterFax")
    private String submitterFax;
    
    @Column(name = "SubmitterExtension")
    private int submitterExtension;
    
    @Column(name = "ContactExtension")
    private int contactExtension;

    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @Embedded
    private AbstractCommonEntity commonComponent;

    public int getAffialiateId() {
        return affialiateId;
    }

    public void setAffialiateId(int affialiateId) {
        this.affialiateId = affialiateId;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getComapnyName() {
        return comapnyName;
    }

    public void setComapnyName(String comapnyName) {
        this.comapnyName = comapnyName;
    }

    public DispatchRegions getDispatchRegion() {
        return dispatchRegion;
    }

    public void setDispatchRegion(DispatchRegions dispatchRegion) {
        this.dispatchRegion = dispatchRegion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNpi() {
        return npi;
    }

    public void setNpi(int npi) {
        this.npi = npi;
    }

    public int getDefaultMedicareLIstValueId() {
        return defaultMedicareLIstValueId;
    }

    public void setDefaultMedicareLIstValueId(int defaultMedicareLIstValueId) {
        this.defaultMedicareLIstValueId = defaultMedicareLIstValueId;
    }

    public int getDefaultMedicaId() {
        return defaultMedicaId;
    }

    public void setDefaultMedicaId(int defaultMedicaId) {
        this.defaultMedicaId = defaultMedicaId;
    }

    public String getFedralTaxId() {
        return fedralTaxId;
    }

    public void setFedralTaxId(String fedralTaxId) {
        this.fedralTaxId = fedralTaxId;
    }

    public String getFedralDrugsId() {
        return fedralDrugsId;
    }

    public void setFedralDrugsId(String fedralDrugsId) {
        this.fedralDrugsId = fedralDrugsId;
    }

    public String getRenderingProvider() {
        return renderingProvider;
    }

    public void setRenderingProvider(String renderingProvider) {
        this.renderingProvider = renderingProvider;
    }

    public String getUpin() {
        return upin;
    }

    public void setUpin(String upin) {
        this.upin = upin;
    }

    public Time getStatTime() {
        return statTime;
    }

    public void setStatTime(Time statTime) {
        this.statTime = statTime;
    }

    public Time getNonStatTime() {
        return nonStatTime;
    }

    public void setNonStatTime(Time nonStatTime) {
        this.nonStatTime = nonStatTime;
    }

    public boolean isSignOnFile() {
        return signOnFile;
    }

    public void setSignOnFile(boolean signOnFile) {
        this.signOnFile = signOnFile;
    }

    public boolean isIsPrintBillDate() {
        return isPrintBillDate;
    }

    public void setIsPrintBillDate(boolean isPrintBillDate) {
        this.isPrintBillDate = isPrintBillDate;
    }

    public boolean isIsFollowWorkflow() {
        return isFollowWorkflow;
    }

    public void setIsFollowWorkflow(boolean isFollowWorkflow) {
        this.isFollowWorkflow = isFollowWorkflow;
    }

    public boolean isIsMoreThanTwoTrip() {
        return isMoreThanTwoTrip;
    }

    public void setIsMoreThanTwoTrip(boolean isMoreThanTwoTrip) {
        this.isMoreThanTwoTrip = isMoreThanTwoTrip;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getScheduleType() {
        return ScheduleType;
    }

    public void setScheduleType(String ScheduleType) {
        this.ScheduleType = ScheduleType;
    }

    public String getContactAddressLine1() {
        return contactAddressLine1;
    }

    public void setContactAddressLine1(String contactAddressLine1) {
        this.contactAddressLine1 = contactAddressLine1;
    }

    public String getContactAddressLine2() {
        return contactAddressLine2;
    }

    public void setContactAddressLine2(String contactAddressLine2) {
        this.contactAddressLine2 = contactAddressLine2;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
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

    public String getContactZipCode() {
        return contactZipCode;
    }

    public void setContactZipCode(String contactZipCode) {
        this.contactZipCode = contactZipCode;
    }

    public String getContactLineLand1() {
        return contactLineLand1;
    }

    public void setContactLineLand1(String contactLineLand1) {
        this.contactLineLand1 = contactLineLand1;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFaxId() {
        return faxId;
    }

    public void setFaxId(String faxId) {
        this.faxId = faxId;
    }

    public String getPrimaryBatchCode() {
        return primaryBatchCode;
    }

    public void setPrimaryBatchCode(String primaryBatchCode) {
        this.primaryBatchCode = primaryBatchCode;
    }

    public String getPrimaryBatchNumber() {
        return primaryBatchNumber;
    }

    public void setPrimaryBatchNumber(String primaryBatchNumber) {
        this.primaryBatchNumber = primaryBatchNumber;
    }

    public String getSecondaryBatchCode() {
        return secondaryBatchCode;
    }

    public void setSecondaryBatchCode(String secondaryBatchCode) {
        this.secondaryBatchCode = secondaryBatchCode;
    }

    public String getSecondaryBatchNumber() {
        return secondaryBatchNumber;
    }

    public void setSecondaryBatchNumber(String secondaryBatchNumber) {
        this.secondaryBatchNumber = secondaryBatchNumber;
    }

    public String getTeriataryBatchCode() {
        return teriataryBatchCode;
    }

    public void setTeriataryBatchCode(String teriataryBatchCode) {
        this.teriataryBatchCode = teriataryBatchCode;
    }

    public String getTeriataryBatchNumber() {
        return teriataryBatchNumber;
    }

    public void setTeriataryBatchNumber(String teriataryBatchNumber) {
        this.teriataryBatchNumber = teriataryBatchNumber;
    }

    public String getPatientInvoiceCode() {
        return patientInvoiceCode;
    }

    public void setPatientInvoiceCode(String patientInvoiceCode) {
        this.patientInvoiceCode = patientInvoiceCode;
    }

    public String getPatientInvoiceNumber() {
        return patientInvoiceNumber;
    }

    public void setPatientInvoiceNumber(String patientInvoiceNumber) {
        this.patientInvoiceNumber = patientInvoiceNumber;
    }

    public String getPspInvoiceCode() {
        return pspInvoiceCode;
    }

    public void setPspInvoiceCode(String pspInvoiceCode) {
        this.pspInvoiceCode = pspInvoiceCode;
    }

    public String getPpsInvoiceNumber() {
        return ppsInvoiceNumber;
    }

    public void setPpsInvoiceNumber(String ppsInvoiceNumber) {
        this.ppsInvoiceNumber = ppsInvoiceNumber;
    }

    public String getPatientPaymentTerm() {
        return patientPaymentTerm;
    }

    public void setPatientPaymentTerm(String patientPaymentTerm) {
        this.patientPaymentTerm = patientPaymentTerm;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getInsuranceCarryForward() {
        return insuranceCarryForward;
    }

    public void setInsuranceCarryForward(String insuranceCarryForward) {
        this.insuranceCarryForward = insuranceCarryForward;
    }

    public String getClearingHouse() {
        return clearingHouse;
    }

    public void setClearingHouse(String clearingHouse) {
        this.clearingHouse = clearingHouse;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getClia() {
        return clia;
    }

    public void setClia(String clia) {
        this.clia = clia;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getReceiverSymbolicId() {
        return receiverSymbolicId;
    }

    public void setReceiverSymbolicId(String receiverSymbolicId) {
        this.receiverSymbolicId = receiverSymbolicId;
    }

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getSubmitterEntityName() {
        return submitterEntityName;
    }

    public void setSubmitterEntityName(String submitterEntityName) {
        this.submitterEntityName = submitterEntityName;
    }

    public String getSubmitterFirstName() {
        return submitterFirstName;
    }

    public void setSubmitterFirstName(String submitterFirstName) {
        this.submitterFirstName = submitterFirstName;
    }

    public String getSubmitterMiddleName() {
        return submitterMiddleName;
    }

    public void setSubmitterMiddleName(String submitterMiddleName) {
        this.submitterMiddleName = submitterMiddleName;
    }

    public String getSubmitterLastName() {
        return submitterLastName;
    }

    public void setSubmitterLastName(String submitterLastName) {
        this.submitterLastName = submitterLastName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmitterPhone() {
        return submitterPhone;
    }

    public void setSubmitterPhone(String submitterPhone) {
        this.submitterPhone = submitterPhone;
    }

    public String getSubmitterFax() {
        return submitterFax;
    }

    public void setSubmitterFax(String submitterFax) {
        this.submitterFax = submitterFax;
    }

    public int getSubmitterExtension() {
        return submitterExtension;
    }

    public void setSubmitterExtension(int submitterExtension) {
        this.submitterExtension = submitterExtension;
    }

    public int getContactExtension() {
        return contactExtension;
    }

    public void setContactExtension(int contactExtension) {
        this.contactExtension = contactExtension;
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
        return "Affiliate{" + "affialiateId=" + affialiateId + ", companyType=" + companyType + ", companyId=" + companyId + ", comapnyName=" + comapnyName + ", dispatchRegion=" + dispatchRegion + ", category=" + category + ", npi=" + npi + ", defaultMedicareLIstValueId=" + defaultMedicareLIstValueId + ", defaultMedicaId=" + defaultMedicaId + ", fedralTaxId=" + fedralTaxId + ", fedralDrugsId=" + fedralDrugsId + ", renderingProvider=" + renderingProvider + ", upin=" + upin + ", statTime=" + statTime + ", nonStatTime=" + nonStatTime + ", signOnFile=" + signOnFile + ", isPrintBillDate=" + isPrintBillDate + ", isFollowWorkflow=" + isFollowWorkflow + ", isMoreThanTwoTrip=" + isMoreThanTwoTrip + ", charges=" + charges + ", facilityType=" + facilityType + ", discount=" + discount + ", ScheduleType=" + ScheduleType + ", contactAddressLine1=" + contactAddressLine1 + ", contactAddressLine2=" + contactAddressLine2 + ", contactCity=" + contactCity + ", state=" + state + ", country=" + country + ", contactZipCode=" + contactZipCode + ", contactLineLand1=" + contactLineLand1 + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", faxId=" + faxId + ", primaryBatchCode=" + primaryBatchCode + ", primaryBatchNumber=" + primaryBatchNumber + ", secondaryBatchCode=" + secondaryBatchCode + ", secondaryBatchNumber=" + secondaryBatchNumber + ", teriataryBatchCode=" + teriataryBatchCode + ", teriataryBatchNumber=" + teriataryBatchNumber + ", patientInvoiceCode=" + patientInvoiceCode + ", patientInvoiceNumber=" + patientInvoiceNumber + ", pspInvoiceCode=" + pspInvoiceCode + ", ppsInvoiceNumber=" + ppsInvoiceNumber + ", patientPaymentTerm=" + patientPaymentTerm + ", providerId=" + providerId + ", insuranceCarryForward=" + insuranceCarryForward + ", clearingHouse=" + clearingHouse + ", format=" + format + ", form=" + form + ", clia=" + clia + ", chargeType=" + chargeType + ", receiverSymbolicId=" + receiverSymbolicId + ", receiverFullName=" + receiverFullName + ", submitterId=" + submitterId + ", submitterEntityName=" + submitterEntityName + ", submitterFirstName=" + submitterFirstName + ", submitterMiddleName=" + submitterMiddleName + ", submitterLastName=" + submitterLastName + ", submitterEmail=" + submitterEmail + ", submitterPhone=" + submitterPhone + ", submitterFax=" + submitterFax + ", submitterExtension=" + submitterExtension + ", contactExtension=" + contactExtension + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
  
}