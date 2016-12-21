/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Technologist;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface ITechnologistRepository {
 
    public List<Technologist> getAllTechnologist();
    public Technologist createTechnologist(Technologist technologist);
    public Technologist getTechnologistByTechnologistId(int technologistId);
    public Technologist updateTechnologist(Technologist technologist);
    public boolean deleteTechnologist(int technologistId);
}
