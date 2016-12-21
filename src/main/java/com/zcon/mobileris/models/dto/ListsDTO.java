/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import com.zcon.mobileris.entity.ListValues;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author PradnyaS
 */
public class ListsDTO implements Serializable{
    private int listId;
    private String listCode;
    private String listName;
    private Set<ListValuesDTO> listValuesObject;

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListCode() {
        return listCode;
    }

    public void setListCode(String listCode) {
        this.listCode = listCode;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Set<ListValuesDTO> getListValuesObject() {
        return listValuesObject;
    }

    public void setListValuesObject(Set<ListValuesDTO> listValuesObject) {
        this.listValuesObject = listValuesObject;
    }

    @Override
    public String toString() {
        return "ListsDTO{" + "listId=" + listId + ", listCode=" + listCode + ", listName=" + listName + ", listValuesObject=" + listValuesObject + '}';
    }

   
    
}
