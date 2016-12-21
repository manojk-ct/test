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
public class TechniqueDTO implements Serializable{
    private int techniqueId;
    private String technique;
    private String description;

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

    @Override
    public String toString() {
        return "TechniqueDTO{" + "techniqueId=" + techniqueId + ", technique=" + technique + ", description=" + description + '}';
    }
    
    
}
