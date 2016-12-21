package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.entity.IcdCode;
import com.zcon.mobileris.entity.Modality;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.entity.States;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ManojK
 */
public interface ListService {

    List<Country> getAllCountries();
    
    List<States> getAllStates(int country_id);

    List<DispatchRegions> getAllDispatchRegions();
    
    List<RadiologyGroup> getAllRadiologyGroups();
    
    List<Modality> getAllModalities();
    
    Set<Modality> getModalitiesByBodyPart(int bodyPartId);
    
    List<Facilities> getAllFacilities();
    
    List<Payer> getAllPayers();
    
    List<IcdCode> getICDBySearchString(String searchString);

}
