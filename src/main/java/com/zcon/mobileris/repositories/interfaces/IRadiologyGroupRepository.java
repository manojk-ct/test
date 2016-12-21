/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;
import com.zcon.mobileris.entity.RadiologyGroup;
import java.util.List;
/**
 *
 * @author PradnyaS
 */
public interface IRadiologyGroupRepository {
    List<RadiologyGroup> getAllRadiologyGroup();
    RadiologyGroup createRadiologist(RadiologyGroup radiologyGroup);
    RadiologyGroup updateRadiologyGroupById(RadiologyGroup radiologyGroup);
    boolean deleteRadiologyGroupById(int radiologyGroupId);
    RadiologyGroup getRadiologyGroupById(int radiologyGroupId);    
}
