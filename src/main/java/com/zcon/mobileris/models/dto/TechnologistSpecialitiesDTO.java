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
public class TechnologistSpecialitiesDTO implements Serializable {
    private int technologistSpecialityId;
    private int technologistId;
    private SpecialityDTO specialityListValueObject;

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

    public SpecialityDTO getSpecialityListValueObject() {
        return specialityListValueObject;
    }

    public void setSpecialityListValueObject(SpecialityDTO specialityListValueObject) {
        this.specialityListValueObject = specialityListValueObject;
    }


    @Override
    public String toString() {
        return "TechnologistSpecialityDTO{" + "technologistSpecialityId=" + technologistSpecialityId + ", technologistId=" + technologistId + ", specialityListValueObject=" + specialityListValueObject + '}';
    }

}
