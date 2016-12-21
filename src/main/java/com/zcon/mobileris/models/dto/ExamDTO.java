package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author ManojK
 */
public class ExamDTO implements Serializable{
   
    private int bodyPartExamId;
    @NotNull
    @Length(min=1,max = 35)
    private String examName;
    @NotNull
    @Length(min=1,max = 35)
    private String examCode;
    private String description;
    @Min(1)
    private int bodyPartId;
    @Min(1)
    private int modalityId;
    private boolean leftFlag;
    private boolean rightFlag;
    private boolean biletralFlag;
    private String leftCPTCase;
    private String rightCPTCase;
    private String biletralCPTCase;
    private long icdCode;
    private char status;

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

    public int getBodyPartId() {
        return bodyPartId;
    }

    public void setBodyPartId(int bodyPartId) {
        this.bodyPartId = bodyPartId;
    }

    public int getModalityId() {
        return modalityId;
    }

    public void setModalityId(int modalityId) {
        this.modalityId = modalityId;
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

    @Override
    public String toString() {
        return "ExamDTO{" + "bodyPartExamId=" + bodyPartExamId + ", examName=" + examName + ", examCode=" + examCode + ", description=" + description + ", bodyPartId=" + bodyPartId + ", modalityId=" + modalityId + ", leftFlag=" + leftFlag + ", rightFlag=" + rightFlag + ", biletralFlag=" + biletralFlag + ", leftCPTCase=" + leftCPTCase + ", rightCPTCase=" + rightCPTCase + ", biletralCPTCase=" + biletralCPTCase + ", icdCode=" + icdCode + ", status=" + status + '}';
    }
    
}
