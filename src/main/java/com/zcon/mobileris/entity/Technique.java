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
@Table(name = "Technique")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechniqueId")
    private int techniqueId;
    
    @Column(name = "Technique")
    private String technique;
    
    @Column(name = "Description")
    private String description;
    
    @Embedded
    private AbstractCommonEntity commonComponent;    

    public int getTechniqueId() {
        return techniqueId;
    }

    public void setTechniqueId(int techniqueId) {
        this.techniqueId = techniqueId;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "Technique{" + "techniqueId=" + techniqueId + ", technique=" + technique + ", description=" + description + ", commonComponent=" + commonComponent + '}';
    }
    
    
}
