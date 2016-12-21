/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author MayuriM
 */

@Entity
@Table(name = "CptModifier")
public class CptModifier{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CptModifierId")
    private int cptModifierId;
    
    @Column(name = "ModifierPayListValueId")
    private int modifierPayListValueId;
    
    @Column(name = "ModifierSubTypeListValueId")
    private int modifierSubTypeListValueId;

    @Column(name = "ModifierCategoryListValueId")
    private int modifierCategoryListValueId;
    
    @Column(name = "ModifierSubCategory")
    private int modifierSubCategory;
    
    @Column(name = "IsActive", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isActive;

    @Column(name = "Description")
    private String description;

    @Column(name = "ModifierRule")
    private String modifierRule;
    
    @Column(name = "IsDeleted", nullable = false, columnDefinition = "bit(1) default false")
    private boolean isDeleted;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "cptId")
    private CptCode cptId;

    @Embedded
    private AbstractCommonEntity commonComponent;
    
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

    public CptCode getCptId() {
        return cptId;
    }

    public void setCptId(CptCode cptId) {
        this.cptId = cptId;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "CptModifier{" + "cptModifierId=" + cptModifierId + ", modifierPayListValueId=" + modifierPayListValueId + ", modifierSubTypeListValueId=" + modifierSubTypeListValueId + ", modifierCategoryListValueId=" + modifierCategoryListValueId + ", modifierSubCategory=" + modifierSubCategory + ", isActive=" + isActive + ", description=" + description + ", modifierRule=" + modifierRule + ", isDeleted=" + isDeleted + ", cptId=" + cptId + ", commonComponent=" + commonComponent + '}';
    }

    
}
