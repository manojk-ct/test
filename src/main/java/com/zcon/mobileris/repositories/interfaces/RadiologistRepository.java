/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Radiologist;
import java.util.List;

/**
 * @author ManioK
 */
public interface RadiologistRepository {
    List<Radiologist> getAllRadiologists();
    Radiologist createRadiologist(Radiologist radiologist);
    Radiologist updateRadiologistById(int radiologistId,Radiologist radiologist);
    Radiologist deleteRadiologistById(int radiologistId);
    Radiologist getRadiologistById(int radiologistId);
}
