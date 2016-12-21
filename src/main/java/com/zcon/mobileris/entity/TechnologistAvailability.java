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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PradnyaS
 */
@Entity
@Table(name = "TechnologistAvailability")
public class TechnologistAvailability {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnologistAvailabilityId")
    private int technologistAvailabilityId;
    
    @Column(name = "TechnologistId", insertable = false, updatable = false)
    private int technologistId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "listValueId")
    private ListValues availabilityDayListValueId;
    
    @Embedded
    private AbstractCommonEntity commonComponent;  

    public int getTechnologistAvailabilityId() {
        return technologistAvailabilityId;
    }

    public void setTechnologistAvailabilityId(int technologistAvailabilityId) {
        this.technologistAvailabilityId = technologistAvailabilityId;
    }

    public int getTechnologistId() {
        return technologistId;
    }

    public void setTechnologistId(int technologistId) {
        this.technologistId = technologistId;
    }

    public ListValues getAvailabilityDayListValueId() {
        return availabilityDayListValueId;
    }

    public void setAvailabilityDayListValueId(ListValues availabilityDayListValueId) {
        this.availabilityDayListValueId = availabilityDayListValueId;
    }

    public AbstractCommonEntity getCommonComponent() {
        return commonComponent;
    }

    public void setCommonComponent(AbstractCommonEntity commonComponent) {
        this.commonComponent = commonComponent;
    }

    @Override
    public String toString() {
        return "TechnologistAvailability{" + "technologistAvailabilityId=" + technologistAvailabilityId + ", technologistId=" + technologistId + ", availabilityDayListValueId=" + availabilityDayListValueId + ", commonComponent=" + commonComponent + '}';
    }

   
    
}
