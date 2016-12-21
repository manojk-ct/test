package com.zcon.mobileris.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Patient_Insurance")
public class Patient_Insurance{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InsuranceId")
    private int insuranceId;

    @Column(name = "InsuranceInfo")
    private String insuranceInfo;

    @Column(name = "InsuranceType")
    private String insuranceType;
    
//    @JoinColumn(name = "patientId", referencedColumnName = "ID")
//    @ManyToOne
    @Column(name = "patientId", insertable = false, updatable = false)
    private int patientId;

    @Column(name = "EligibilityStatus")
    private String eligibilityStatus;

    @Column(name = "StatusMessage")
    private String statusMessage;

    @Column(name = "CheckedOn")
    private String checkedOn;

    @Column(name = "Coverage")
    private String coverage;

    @Column(name = "Usage1")
    private String usages;

    @Column(name = "PriorAuthorisation")
    private boolean priorAuthorisation;

    @Column(name = "InNetwork1")
    private boolean inNetwork;

    @Column(name = "OutOfNetwork")
    private boolean outOfNetwork;

    @Column(name = "ReferealNeccessary")
    private boolean referealNeccessary;

    @Column(name = "SelfGuarantor")
    private boolean selfGuarantor;

    @Column(name = "GuarantorFirstName")
    private String guarantorFirstName;

    @Column(name = "GuarantorMiddleName")
    private String guarantorMiddleName;

    @Column(name = "GuarantorLastName")
    private String guarantorLastName;

    @Column(name = "Relationship1")
    private String relationship;

    @Column(name = "GuarantorSSN")
    private String guarantorSSN;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "GuarantorDOB")
    private Date guarantorDOB;

    @Column(name = "GuarantorGender")
    private String guarantorGender;

    @Column(name = "GuarantorPhoneExtension")
    private long guarantorPhoneExtension;
    
    @Column(name = "GuarantorPhone")
    private String guarantorPhone;

    @Column(name = "PolicyNo")
    private String policyNo;

    @Column(name = "GroupId")
    private String groupId;

    @Column(name = "Contract1")
    private String contract;

    @Column(name = "BillingCode")
    private String billingCode;

    @Column(name = "Network1")
    private String network;

    @Column(name = "InsuranceTypeCode")
    private String insuranceTypeCode;

    @Column(name = "EmployerName")
    private String employerName;

    @Column(name = "SchoolName")
    private String schoolName;

    @Column(name = "OfficeCoPay")
    private float officeCoPay;

    @Column(name = "DeducibleRemaining")
    private float deducibleRemaining;

    @Column(name = "EmployerPhoneExtension")
    private long employerPhoneExtension;
    
    @Column(name = "EmployerPhone")
    private String employerPhone;

    @Column(name = "ServiceType1")
    private String serviceType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "EffectiveStartDate")
    private Date effectiveStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "EffectiveEndDate")
    private Date effectiveEndDate;

    @Column(name = "AdjusterFirstName")
    private String adjusterFirstName;

    @Column(name = "AdjusterLastName")
    private String adjusterLastName;

     @Column(name = "AdjusterPhoneExtension")
    private long adjusterPhoneExtension;
    
    @Column(name = "AdjusterPhone")
    private String adjusterPhone;

    @Column(name = "WCBCase")
    private String wcbCase;

    @Column(name = "PolicyHolder")
    private String policyHolder;

    @Column(name = "AttorneyName")
    private String attorneyName;

    @Column(name = "AttorneyPhoneExtension")
    private long attorneyPhoneExtension;

    @Column(name = "AttorneyPhone")
    private String attorneyPhone;

//    @Column(name = "ClaimAddressLine1")
//    private String claimAddressLine1;
//
//    @Column(name = "ClaimAddressLine2")
//    private String claimAddressLine2;
//
//    @Column(name = "ClaimCity")
//    private String claimCity;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinColumn(name = "ClaimStateId")
//    private States claimStateId;
//    
//    @OneToOne(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinColumn(name = "ClaimCountryId")
//    private Country claimCountryId;
//    
//    @Column(name = "ClaimZipCode")
//    private long claimZipCode;

//    @OneToOne(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinColumn(name = "PayerId")
//    private Payer payerId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "PayerId")
    private Payer payerId;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Payer getPayerId() {
        return payerId;
    }

    public void setPayerId(Payer payerId) {
        this.payerId = payerId;
    }

    
//    public int getPayerId() {
//        return payerId;
//    }
//
//    public void setPayerId(int payerId) {
//        this.payerId = payerId;
//    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public float getOfficeCoPay() {
        return officeCoPay;
    }

    public void setOfficeCoPay(float officeCoPay) {
        this.officeCoPay = officeCoPay;
    }

    public float getDeducibleRemaining() {
        return deducibleRemaining;
    }

    public void setDeducibleRemaining(float deducibleRemaining) {
        this.deducibleRemaining = deducibleRemaining;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getEligibilityStatus() {
        return eligibilityStatus;
    }

    public void setEligibilityStatus(String eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getCheckedOn() {
        return checkedOn;
    }

    public void setCheckedOn(String checkedOn) {
        this.checkedOn = checkedOn;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsage(String usages) {
        this.usages = usages;
    }

    public boolean isPriorAuthorisation() {
        return priorAuthorisation;
    }

    public void setPriorAuthorisation(boolean priorAuthorisation) {
        this.priorAuthorisation = priorAuthorisation;
    }

    public boolean isInNetwork() {
        return inNetwork;
    }

    public void setInNetwork(boolean inNetwork) {
        this.inNetwork = inNetwork;
    }

    public boolean isOutOfNetwork() {
        return outOfNetwork;
    }

    public void setOutOfNetwork(boolean outOfNetwork) {
        this.outOfNetwork = outOfNetwork;
    }

    public boolean isReferealNeccessary() {
        return referealNeccessary;
    }

    public void setReferealNeccessary(boolean referealNeccessary) {
        this.referealNeccessary = referealNeccessary;
    }

    public boolean isSelfGuarantor() {
        return selfGuarantor;
    }

    public void setSelfGuarantor(boolean selfGuarantor) {
        this.selfGuarantor = selfGuarantor;
    }

    public String getGuarantorFirstName() {
        return guarantorFirstName;
    }

    public void setGuarantorFirstName(String guarantorFirstName) {
        this.guarantorFirstName = guarantorFirstName;
    }

    public String getGuarantorMiddleName() {
        return guarantorMiddleName;
    }

    public void setGuarantorMiddleName(String guarantorMiddleName) {
        this.guarantorMiddleName = guarantorMiddleName;
    }

    public String getGuarantorLastName() {
        return guarantorLastName;
    }

    public void setGuarantorLastName(String guarantorLastName) {
        this.guarantorLastName = guarantorLastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getGuarantorSSN() {
        return guarantorSSN;
    }

    public void setGuarantorSSN(String guarantorSSN) {
        this.guarantorSSN = guarantorSSN;
    }

    public Date getGuarantorDOB() {
        return guarantorDOB;
    }

    public void setGuarantorDOB(Date guarantorDOB) {
        this.guarantorDOB = guarantorDOB;
    }

    public String getGuarantorGender() {
        return guarantorGender;
    }

    public void setGuarantorGender(String guarantorGender) {
        this.guarantorGender = guarantorGender;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getInsuranceTypeCode() {
        return insuranceTypeCode;
    }

    public void setInsuranceTypeCode(String insuranceTypeCode) {
        this.insuranceTypeCode = insuranceTypeCode;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public String getAdjusterFirstName() {
        return adjusterFirstName;
    }

    public void setAdjusterFirstName(String adjusterFirstName) {
        this.adjusterFirstName = adjusterFirstName;
    }

    public String getAdjusterLastName() {
        return adjusterLastName;
    }

    public void setAdjusterLastName(String adjusterLastName) {
        this.adjusterLastName = adjusterLastName;
    }

    public String getWcbCase() {
        return wcbCase;
    }

    public void setWcbCase(String wcbCase) {
        this.wcbCase = wcbCase;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getAttorneyName() {
        return attorneyName;
    }

    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }

    public long getGuarantorPhoneExtension() {
        return guarantorPhoneExtension;
    }

    public void setGuarantorPhoneExtension(long guarantorPhoneExtension) {
        this.guarantorPhoneExtension = guarantorPhoneExtension;
    }

    public String getGuarantorPhone() {
        return guarantorPhone;
    }

    public void setGuarantorPhone(String guarantorPhone) {
        this.guarantorPhone = guarantorPhone;
    }

    public long getEmployerPhoneExtension() {
        return employerPhoneExtension;
    }

    public void setEmployerPhoneExtension(long employerPhoneExtension) {
        this.employerPhoneExtension = employerPhoneExtension;
    }

    public String getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        this.employerPhone = employerPhone;
    }

    public long getAdjusterPhoneExtension() {
        return adjusterPhoneExtension;
    }

    public void setAdjusterPhoneExtension(long adjusterPhoneExtension) {
        this.adjusterPhoneExtension = adjusterPhoneExtension;
    }

    public String getAdjusterPhone() {
        return adjusterPhone;
    }

    public void setAdjusterPhone(String adjusterPhone) {
        this.adjusterPhone = adjusterPhone;
    }

    public long getAttorneyPhoneExtension() {
        return attorneyPhoneExtension;
    }

    public void setAttorneyPhoneExtension(long attorneyPhoneExtension) {
        this.attorneyPhoneExtension = attorneyPhoneExtension;
    }

    public String getAttorneyPhone() {
        return attorneyPhone;
    }

    public void setAttorneyPhone(String attorneyPhone) {
        this.attorneyPhone = attorneyPhone;
    }

//    public String getClaimAddressLine1() {
//        return claimAddressLine1;
//    }
//
//    public void setClaimAddressLine1(String claimAddressLine1) {
//        this.claimAddressLine1 = claimAddressLine1;
//    }
//
//    public String getClaimAddressLine2() {
//        return claimAddressLine2;
//    }
//
//    public void setClaimAddressLine2(String claimAddressLine2) {
//        this.claimAddressLine2 = claimAddressLine2;
//    }
//
//    public String getClaimCity() {
//        return claimCity;
//    }
//
//    public void setClaimCity(String claimCity) {
//        this.claimCity = claimCity;
//    }
//    
//    public States getClaimStateId() {
//        return claimStateId;
//    }
//
//    public void setClaimStateId(States claimStateId) {
//        this.claimStateId = claimStateId;
//    }
//
//    public Country getClaimCountryId() {
//        return claimCountryId;
//    }
//
//    public void setClaimCountryId(Country claimCountryId) {    
//        this.claimCountryId = claimCountryId;
//    }
//
//    public long getClaimZipCode() {
//        return claimZipCode;
//    }
//
//    public void setClaimZipCode(long claimZipCode) {
//        this.claimZipCode = claimZipCode;
//    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Patient_Insurance{" + "insuranceId=" + insuranceId + ", insuranceInfo=" + insuranceInfo + ", insuranceType=" + insuranceType + ", patientId=" + patientId + ", eligibilityStatus=" + eligibilityStatus + ", statusMessage=" + statusMessage + ", checkedOn=" + checkedOn + ", coverage=" + coverage + ", usages=" + usages + ", priorAuthorisation=" + priorAuthorisation + ", inNetwork=" + inNetwork + ", outOfNetwork=" + outOfNetwork + ", referealNeccessary=" + referealNeccessary + ", selfGuarantor=" + selfGuarantor + ", guarantorFirstName=" + guarantorFirstName + ", guarantorMiddleName=" + guarantorMiddleName + ", guarantorLastName=" + guarantorLastName + ", relationship=" + relationship + ", guarantorSSN=" + guarantorSSN + ", guarantorDOB=" + guarantorDOB + ", guarantorGender=" + guarantorGender + ", guarantorPhoneExtension=" + guarantorPhoneExtension + ", guarantorPhone=" + guarantorPhone + ", policyNo=" + policyNo + ", groupId=" + groupId + ", contract=" + contract + ", billingCode=" + billingCode + ", network=" + network + ", insuranceTypeCode=" + insuranceTypeCode + ", employerName=" + employerName + ", schoolName=" + schoolName + ", officeCoPay=" + officeCoPay + ", deducibleRemaining=" + deducibleRemaining + ", employerPhoneExtension=" + employerPhoneExtension + ", employerPhone=" + employerPhone + ", serviceType=" + serviceType + ", effectiveStartDate=" + effectiveStartDate + ", effectiveEndDate=" + effectiveEndDate + ", adjusterFirstName=" + adjusterFirstName + ", adjusterLastName=" + adjusterLastName + ", adjusterPhoneExtension=" + adjusterPhoneExtension + ", adjusterPhone=" + adjusterPhone + ", wcbCase=" + wcbCase + ", policyHolder=" + policyHolder + ", attorneyName=" + attorneyName + ", attorneyPhoneExtension=" + attorneyPhoneExtension + ", attorneyPhone=" + attorneyPhone + ", payerId=" + payerId + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }

}
