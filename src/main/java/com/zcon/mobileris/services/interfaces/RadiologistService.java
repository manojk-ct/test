/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.models.dto.RadiologistDTO;
import java.util.List;

/**
 *
 * @author ManojK
 */
public interface RadiologistService {
    List<RadiologistDTO> getAllRadiologists();
    RadiologistDTO createRadiologist(RadiologistDTO radiologist);
    RadiologistDTO updateRadiologistById(int radiologistId,RadiologistDTO radiologist);
    RadiologistDTO deleteRadiologistById(int radiologistId);
    RadiologistDTO getRadiologistById(int radiologistId) throws RecordNotFoundException;
}
