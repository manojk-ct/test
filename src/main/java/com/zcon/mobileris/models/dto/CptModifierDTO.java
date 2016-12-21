/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;

/**
 *
 * @author PradnyaS
 */
public class CptModifierDTO implements Serializable{
  
    private int cptModifierId;
    private int modifierPayListValueId;
    private int modifierSubTypeListValueId;
    private int modifierCategoryListValueId;
    private int modifierSubCategory;
    private boolean isActive;
    private String description;
    private String modifierRule;
    private boolean isDeleted;
    @Min(1)
    private int cptId;

    public int getCptModifierId() {
        return cptModifierId;
    }

    public void setCptModifierId(int cptModifierId) {
        this.cptModifierId = cptModifierId;
    }

    public int getModifierPayListValueId() {
        return modifierPayListValueId;
    }

    public void setModifierPayListValueId(int modifierPayListValueId) {
        this.modifierPayListValueId = modifierPayListValueId;
    }

    public int getModifierSubTypeListValueId() {
        return modifierSubTypeListValueId;
    }

    public void setModifierSubTypeListValueId(int modifierSubTypeListValueId) {
        this.modifierSubTypeListValueId = modifierSubTypeListValueId;
    }

    public int getModifierCategoryListValueId() {
        return modifierCategoryListValueId;
    }

    public void setModifierCategoryListValueId(int modifierCategoryListValueId) {
        this.modifierCategoryListValueId = modifierCategoryListValueId;
    }

    public int getModifierSubCategory() {
        return modifierSubCategory;
    }

    public void setModifierSubCategory(int modifierSubCategory) {
        this.modifierSubCategory = modifierSubCategory;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModifierRule() {
        return modifierRule;
    }

    public void setModifierRule(String modifierRule) {
        this.modifierRule = modifierRule;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getCptId() {
        return cptId;
    }

    public void setCptId(int cptId) {
        this.cptId = cptId;
    }

    @Override
    public String toString() {
        return "CptModifierDTO{" + "cptModifierId=" + cptModifierId + ", modifierPayListValueId=" + modifierPayListValueId + ", modifierSubTypeListValueId=" + modifierSubTypeListValueId + ", modifierCategoryListValueId=" + modifierCategoryListValueId + ", modifierSubCategory=" + modifierSubCategory + ", isActive=" + isActive + ", description=" + description + ", modifierRule=" + modifierRule + ", isDeleted=" + isDeleted + ", cptId=" + cptId + '}';
    }
    
    
}
