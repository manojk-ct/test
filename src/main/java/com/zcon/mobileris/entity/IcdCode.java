/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManojK
 */

@Entity
@Table(name = "ICD")
public class IcdCode{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ICDId")
    private int icdId;
    
    @Column(name = "OrderNumber",length = 5)
    private int orderNumber;
    
    @Column(name = "Code",length = 20)
    private String code;
    
    @Column(name = "IsValidForHIPAATransaction")
    private boolean isValidForHIPAATransaction;
    
    @Column(name = "ShortDescription")
    private String shortDesc;
    
    @Column(name = "LongDescription")
    private String longDesc;
    
    @Column(name = "Remark")
    private String remark;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

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

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "IcdCode{" + "icdId=" + icdId + ", orderNumber=" + orderNumber + ", code=" + code + ", isValidForHIPAATransaction=" + isValidForHIPAATransaction + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc + ", remark=" + remark + ", commonComponent=" + commonComponent + '}';
    }

    
    
}