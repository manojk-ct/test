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
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "Listvalues")
public class ListValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ListValueId")
    private int listValueId;
    
    @Column(name = "ListId")
    private int listId;
    
    @Column(name = "ListValue")
    private String listValue;
    
    @Column(name = "ListValueCode")
    private String listValueCode;
    
    @Column(name = "SequenceNo")
    private int sequenceNo;
    
    @Column(name = "IsAccessible", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isAccessible;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "IsActive", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isActive;
    
//    @Embedded
//    private AbstractCommonEntity commonComponent;  

    public int getListValueId() {
        return listValueId;
    }

    public void setListValueId(int listValueId) {
        this.listValueId = listValueId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public String getListValueCode() {
        return listValueCode;
    }

    public void setListValueCode(String listValueCode) {
        this.listValueCode = listValueCode;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public boolean isIsAccessible() {
        return isAccessible;
    }

    public void setIsAccessible(boolean isAccessible) {
        this.isAccessible = isAccessible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

//    public AbstractCommonEntity getCommonComponent() {
//        return commonComponent;
//    }
//
//    public void setCommonComponent(AbstractCommonEntity commonComponent) {
//        this.commonComponent = commonComponent;
//    }

    @Override
    public String toString() {
        return "ListValues{" + "listValueId=" + listValueId + ", listId=" + listId + ", listValue=" + listValue + ", listValueCode=" + listValueCode + ", sequenceNo=" + sequenceNo + ", isAccessible=" + isAccessible + ", description=" + description + ", isActive=" + isActive + '}';
    }

        
}
