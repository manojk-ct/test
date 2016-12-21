package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.BodyPartExam;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.IBodyPartRepository;
import com.zcon.mobileris.repositories.interfaces.IListRepository;
import com.zcon.mobileris.services.interfaces.IListService;

/**
 * @author ManojK
 */
@Service("listService")
@Transactional
public class ListServiceImpl implements IListService {

    @Autowired
    IListRepository listRepository;
    
    @Autowired
    IBodyPartRepository bodyPartRepository;

    @Override
    public List<Country> getAllCountries() {
        return listRepository.getAllCountries();
    }
    
    @Override
    public List<States> getAllStates(int country_id) {
        return listRepository.getAllStates(country_id);
    }

    @Override
    public List<DispatchRegions> getAllDispatchRegions() {
        return listRepository.getAllDispatchRegions();
    }
        
    @Override
    public List<RadiologyGroup> getAllRadiologyGroups() {
        return listRepository.getAllRadiologyGroups();
    }
    
    @Override
    public List<Modality> getAllModalities() {
        return listRepository.getAllModalities();
    }

    @Override
    public List<Facilities> getAllFacilities() {
         return listRepository.getAllFacilities();
    
    }

    @Override
    public List<Payer> getAllPayers() {
        return listRepository.getAllPayers();
    }

    @Override
    public Set<Modality> getModalitiesByBodyPart(int bodyPartId) {
        return bodyPartRepository.getBodyPartById(bodyPartId).getModality();
    }

    @Override
    public List<IcdCode> getICDBySearchString(String searchString) {
        return listRepository.getICDBySearchString(searchString);
    }

    @Override
    public List<BodyPartExam> getAllExams() {
        return listRepository.getAllExams();
    }
    
}
