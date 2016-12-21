/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.FacilitiesDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IFacilityService {
    public List<FacilitiesDTO> getAllFacilities();
    public FacilitiesDTO createFacility(FacilitiesDTO facility);
    public FacilitiesDTO getFacilityByFacilityId(int facility_id);
    public FacilitiesDTO updateFacility(FacilitiesDTO facility);
    public boolean deleteFacility(int facility_id);
}
