/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.TechnologistDTO;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface ITechnologistService {
    
    public List<TechnologistDTO> getAllTechnologist();
    public TechnologistDTO createTechnologist(TechnologistDTO technologist);
    public TechnologistDTO getTechnologistByTechnologistId(int technologistId);
    public TechnologistDTO updateTechnologist(TechnologistDTO technologist);
    public boolean deleteTechnologist(int technologistId);
}
