/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.models.dto.FacilitiesDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IFacilityRepository {
    public List<Facilities> getAllFacilities();
    public Facilities createFacility(Facilities facility);
    public Facilities getFacilityByFacilityId(int facility_id);
    public Facilities updateFacility(Facilities facility);
    public boolean deleteFacility(int facility_id);
}
