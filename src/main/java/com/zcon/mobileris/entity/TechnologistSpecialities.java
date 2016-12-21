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
@Table(name = "TechnologistSpecialities")
public class TechnologistSpecialities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnologistSpecialityId")
    private int technologistSpecialityId;
    
    @Column(name = "TechnologistId", insertable = false, updatable = false)
    private int technologistId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "specialityId")
    private Speciality specialityListValueObject;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getTechnologistSpecialityId() {
        return technologistSpecialityId;
    }

    public void setTechnologistSpecialityId(int technologistSpecialityId) {
        this.technologistSpecialityId = technologistSpecialityId;
    }

    public int getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(int technologistId) {
        this.technologistId = technologistId;
    }

    public Speciality getSpecialityListValueObject() {
        return specialityListValueObject;
    }

    public void setSpecialityListValueObject(Speciality specialityListValueObject) {
        this.specialityListValueObject = specialityListValueObject;
    }

   

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "TechnologistSpecialities{" + "technologistSpecialityId=" + technologistSpecialityId + ", technologistId=" + technologistId + ", specialityListValueObject=" + specialityListValueObject + ", commonComponent=" + commonComponent + '}';
    }

    
    
    
}
