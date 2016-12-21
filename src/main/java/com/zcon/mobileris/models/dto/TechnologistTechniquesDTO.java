/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author PradnyaS
 */
public class TechnologistTechniquesDTO implements Serializable{
    
    private int technologistTechniqueId;
    private int technologistId;
    private TechniqueDTO techniqueListValueObject;

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

    public TechniqueDTO getTechniqueListValueObject() {
        return techniqueListValueObject;
    }

    public void setTechniqueListValueObject(TechniqueDTO techniqueListValueObject) {
        this.techniqueListValueObject = techniqueListValueObject;
    }

    
    
    
}
