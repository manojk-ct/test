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
@Table(name = "Speciality")
public class Speciality {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecialityId")
    private int specialityId;
    
    @Column(name = "Speciality")
    private String speciality;
    
    @Column(name = "Description")
    private String description;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
        return "Speciality{" + "specialityId=" + specialityId + ", speciality=" + speciality + ", description=" + description + ", commonComponent=" + commonComponent + '}';
    }
    
}
