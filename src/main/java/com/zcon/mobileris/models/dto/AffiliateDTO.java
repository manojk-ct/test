/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MayuriM
 */
public class AffiliateDTO implements Serializable{
    private int affialiateId;
    @Min(1)
    private int dispatchRegionId;
    private String companyType;
    private String companyId;
    @NotNull
    @Length(min=1,max = 35)
    private String comapnyName;
    private String category;
    private int npi;
    private int defaultMedicareListValueId;
    private int defaultMedicaId;
    private String fedralTaxId;
    private String fedralDrugsId;
    private String renderingProvider;
    private String upin;
    private String statTime;
    private String nonStatTime;
    private boolean signOnFile;
    private boolean isPrintBillDate;
    private boolean isFollowWorkflow;
    private boolean isMoreThanTwoTrip;
    private double charges;
    private String chargesType;
    private double discount;
    private String discountType;
    private String contactAddressLine1;
    private String contactAddressLine2;
    private String contactCity;
    private int contactStateId;
    private int contactCountryId;
    private String contactZipCode;
    private String contactLineLand1;
    private String mobileNo;
    @Email
    private String emailId;
    private String faxId;
    private String primaryBatchCode;
    private String primaryBatchNumber;
    private String secondaryBatchCode;
    private String secondaryBatchNumber;
    private String teriataryBatchCode;
    private String teriataryBatchNumber;
    private String patientInvoiceCode;
    private String patientInvoiceNumber;
    private String pspInvoiceCode;
    private String ppsInvoiceNumber;
    private String patientPaymentTerm;
    private String providerId;
    private String insuranceCarryForward;
    private String clearingHouse;
    private String format;
    private String form;
    private String clia;
    private String chargeType;
    private String receiverSymbolicId;
    private String receiverFullName;
    private String submitterId;
    private String submitterEntityName;
    private String submitterFirstName;
    private String submitterMiddleName;
    private String submitterLastName;
    private String submitterEmail;
    private String submitterPhone;
    private String submitterFax;    

    public int getAffialiateId() {
        return affialiateId;
    }

    public void setAffialiateId(int affialiateId) {
        this.affialiateId = affialiateId;
    }

    public int getDispatchRegionId() {
        return dispatchRegionId;
    }

    public void setDispatchRegionId(int dispatchRegionId) {
        this.dispatchRegionId = dispatchRegionId;
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

    public int getDefaultMedicareListValueId() {
        return defaultMedicareListValueId;
    }

    public void setDefaultMedicareListValueId(int defaultMedicareListValueId) {
        this.defaultMedicareListValueId = defaultMedicareListValueId;
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

    public String getStatTime() {
        return statTime;
    }

    public void setStatTime(String statTime) {
        this.statTime = statTime;
    }

    public String getNonStatTime() {
        return nonStatTime;
    }

    public void setNonStatTime(String nonStatTime) {
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

    public String getChargesType() {
        return chargesType;
    }

    public void setChargesType(String chargesType) {
        this.chargesType = chargesType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
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

    public int getContactStateId() {
        return contactStateId;
    }

    public void setContactStateId(int contactStateId) {
        this.contactStateId = contactStateId;
    }

    public int getContactCountryId() {
        return contactCountryId;
    }

    public void setContactCountryId(int contactCountryId) {
        this.contactCountryId = contactCountryId;
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

    @Override
    public String toString() {
        return "AffiliateDTO{" + "affialiateId=" + affialiateId + ", dispatchRegionId=" + dispatchRegionId + ", companyType=" + companyType + ", companyId=" + companyId + ", comapnyName=" + comapnyName + ", category=" + category + ", npi=" + npi + ", defaultMedicareListValueId=" + defaultMedicareListValueId + ", defaultMedicaId=" + defaultMedicaId + ", fedralTaxId=" + fedralTaxId + ", fedralDrugsId=" + fedralDrugsId + ", renderingProvider=" + renderingProvider + ", upin=" + upin + ", statTime=" + statTime + ", nonStatTime=" + nonStatTime + ", signOnFile=" + signOnFile + ", isPrintBillDate=" + isPrintBillDate + ", isFollowWorkflow=" + isFollowWorkflow + ", isMoreThanTwoTrip=" + isMoreThanTwoTrip + ", charges=" + charges + ", chargesType=" + chargesType + ", discount=" + discount + ", discountType=" + discountType + ", contactAddressLine1=" + contactAddressLine1 + ", contactAddressLine2=" + contactAddressLine2 + ", contactCity=" + contactCity + ", contactStateId=" + contactStateId + ", contactCountryId=" + contactCountryId + ", contactZipCode=" + contactZipCode + ", contactLineLand1=" + contactLineLand1 + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", faxId=" + faxId + ", primaryBatchCode=" + primaryBatchCode + ", primaryBatchNumber=" + primaryBatchNumber + ", secondaryBatchCode=" + secondaryBatchCode + ", secondaryBatchNumber=" + secondaryBatchNumber + ", teriataryBatchCode=" + teriataryBatchCode + ", teriataryBatchNumber=" + teriataryBatchNumber + ", patientInvoiceCode=" + patientInvoiceCode + ", patientInvoiceNumber=" + patientInvoiceNumber + ", pspInvoiceCode=" + pspInvoiceCode + ", ppsInvoiceNumber=" + ppsInvoiceNumber + ", patientPaymentTerm=" + patientPaymentTerm + ", providerId=" + providerId + ", insuranceCarryForward=" + insuranceCarryForward + ", clearingHouse=" + clearingHouse + ", format=" + format + ", form=" + form + ", clia=" + clia + ", chargeType=" + chargeType + ", receiverSymbolicId=" + receiverSymbolicId + ", receiverFullName=" + receiverFullName + ", submitterId=" + submitterId + ", submitterEntityName=" + submitterEntityName + ", submitterFirstName=" + submitterFirstName + ", submitterMiddleName=" + submitterMiddleName + ", submitterLastName=" + submitterLastName + ", submitterEmail=" + submitterEmail + ", submitterPhone=" + submitterPhone + ", submitterFax=" + submitterFax + '}';
    }

    
}