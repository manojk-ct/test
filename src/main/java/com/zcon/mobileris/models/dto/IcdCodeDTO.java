/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author MayuriM
 */
public class IcdCodeDTO implements Serializable{
   
    private int icdId;
    @Min(1)
    private int orderNumber;
    @NotNull
    @Length(min=1,max = 35)
    private String code;
    private boolean isValidForHIPAATransaction;
    private String shortDesc;
    private String longDesc;
    private String remark;
   
    public int getIcdId() {
        return icdId;
    }

    public void setIcdId(int icdId) {
        this.icdId = icdId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isIsValidForHIPAATransaction() {
        return isValidForHIPAATransaction;
    }

    public void setIsValidForHIPAATransaction(boolean isValidForHIPAATransaction) {
        this.isValidForHIPAATransaction = isValidForHIPAATransaction;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "IcdCodeDTO{" + "icdId=" + icdId + ", orderNumber=" + orderNumber + ", code=" + code + ", isValidForHIPAATransaction=" + isValidForHIPAATransaction + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc + ", remark=" + remark + '}';
    }
    
}