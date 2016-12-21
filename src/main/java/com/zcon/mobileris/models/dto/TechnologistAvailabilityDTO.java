/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import com.zcon.mobileris.entity.ListValues;
import java.io.Serializable;

/**
 *
 * @author PradnyaS
 */
public class TechnologistAvailabilityDTO implements Serializable{
    private int technologistAvailabilityId;
    private int technologistId;
    private ListValues availabilityDayListValueId;

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

    @Override
    public String toString() {
        return "TechnologistAvailabilityDTO{" + "technologistAvailabilityId=" + technologistAvailabilityId + ", technologistId=" + technologistId + ", availabilityDayListValueId=" + availabilityDayListValueId + '}';
    }
}
