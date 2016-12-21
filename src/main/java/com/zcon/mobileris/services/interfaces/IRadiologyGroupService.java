/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.RadiologyGroupDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IRadiologyGroupService {
    List<RadiologyGroupDTO> getAllRadiologyGroup();
    RadiologyGroupDTO createRadiologist(RadiologyGroupDTO radiologyGroup);
    RadiologyGroupDTO updateRadiologyGroupById(RadiologyGroupDTO radiologyGroup);
    boolean deleteRadiologyGroupById(int radiologyGroupId);
    RadiologyGroupDTO getRadiologyGroupById(int radiologyGroupId);
}
