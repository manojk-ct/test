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
@Table(name = "BodyPartExam")
public class BodyPartExam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BodyPartExamId")    
    private int bodyPartExamId;
    
    @Column(name = "ExamName")
    private String examName;
    
    @Column(name = "ExamCode",length = 35)
    private String examCode;
    
    @Column(name = "Description")
    private String description;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "BodyPartId")    
    private BodyPart bodyPart;
    
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "ModalityId")
    private Modality modality;
    
    @Column(name = "LeftFlag")
    private boolean leftFlag;
    
    @Column(name = "RightFlag")
    private boolean rightFlag;
    
    @Column(name = "BiletralFlag")
    private boolean biletralFlag;
    
    @Column(name = "LeftCPTCase")
    private String leftCPTCase;
    
    @Column(name = "RightCPTCase")
    private String rightCPTCase;
    
    @Column(name = "BiletralCPTCase")
    private String biletralCPTCase;
    
    @Column(name = "ICDCode")
    private long icdCode;
    
    @Column(name = "Status")
    private char status;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;
    
    @Embedded
    private AbstractCommonEntity commonComponent;
    
    public int getBodyPartExamId() {
        return bodyPartExamId;
    }

    public void setBodyPartExamId(int bodyPartExamId) {
        this.bodyPartExamId = bodyPartExamId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public long getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(long icdCode) {
        this.icdCode = icdCode;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public boolean isLeftFlag() {
        return leftFlag;
    }

    public void setLeftFlag(boolean leftFlag) {
        this.leftFlag = leftFlag;
    }

    public boolean isRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(boolean rightFlag) {
        this.rightFlag = rightFlag;
    }

    public boolean isBiletralFlag() {
        return biletralFlag;
    }

    public void setBiletralFlag(boolean biletralFlag) {
        this.biletralFlag = biletralFlag;
    }

    public String getLeftCPTCase() {
        return leftCPTCase;
    }

    public void setLeftCPTCase(String leftCPTCase) {
        this.leftCPTCase = leftCPTCase;
    }

    public String getRightCPTCase() {
        return rightCPTCase;
    }

    public void setRightCPTCase(String rightCPTCase) {
        this.rightCPTCase = rightCPTCase;
    }

    public String getBiletralCPTCase() {
        return biletralCPTCase;
    }

    public void setBiletralCPTCase(String biletralCPTCase) {
        this.biletralCPTCase = biletralCPTCase;
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
        return "BodyPartExam{" + "bodyPartExamId=" + bodyPartExamId + ", examName=" + examName + ", examCode=" + examCode + ", description=" + description + ", bodyPart=" + bodyPart + ", modality=" + modality + ", leftFlag=" + leftFlag + ", rightFlag=" + rightFlag + ", biletralFlag=" + biletralFlag + ", leftCPTCase=" + leftCPTCase + ", rightCPTCase=" + rightCPTCase + ", biletralCPTCase=" + biletralCPTCase + ", icdCode=" + icdCode + ", status=" + status + ", isDeleted=" + isDeleted + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
