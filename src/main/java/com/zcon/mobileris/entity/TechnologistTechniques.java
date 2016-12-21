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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "TechnologistTechniques")
public class TechnologistTechniques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnologistTechniqueId")
    private int technologistTechniqueId;
    
    @Column(name = "TechnologistId", insertable = false, updatable = false)
    private int technologistId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "techniqueId")
    private Technique techniqueListValueObject;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getTechnologistTechniqueId() {
        return technologistTechniqueId;
    }

    public void setTechnologistTechniqueId(int technologistTechniqueId) {
        this.technologistTechniqueId = technologistTechniqueId;
    }

    public int getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(int technologistId) {
        this.technologistId = technologistId;
    }

    public Technique getTechniqueListValueObject() {
        return techniqueListValueObject;
    }

    public void setTechniqueListValueObject(Technique techniqueListValueObject) {
        this.techniqueListValueObject = techniqueListValueObject;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "TechnologistTechniques{" + "technologistTechniqueId=" + technologistTechniqueId + ", technologistId=" + technologistId + ", techniqueListValueObject=" + techniqueListValueObject + ", commonComponent=" + commonComponent + '}';
    }
    
}
