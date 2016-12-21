/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;

/**
 *
 * @author PradnyaS
 */
public class ListValuesDTO implements Serializable {
    private int listValueId;
    private int listId;
    private String listValue;
    private String listValueCode;
    private int sequenceNo;
    private boolean isAccessible;
    private String description;
    private boolean isActive;

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

    @Override
    public String toString() {
        return "ListValuesDTO{" + "listValueId=" + listValueId + ", listId=" + listId + ", listValue=" + listValue + ", listValueCode=" + listValueCode + ", sequenceNo=" + sequenceNo + ", isAccessible=" + isAccessible + ", description=" + description + ", isActive=" + isActive + '}';
    }
    
}
