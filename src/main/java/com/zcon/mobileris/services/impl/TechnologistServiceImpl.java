/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.entity.Technologist;
import com.zcon.mobileris.entity.TechnologistAvailability;
import com.zcon.mobileris.entity.TechnologistSpecialities;
import com.zcon.mobileris.entity.TechnologistTechniques;
import com.zcon.mobileris.models.dto.TechnologistAvailabilityDTO;
import com.zcon.mobileris.models.dto.TechnologistDTO;
import com.zcon.mobileris.models.dto.TechnologistSpecialitiesDTO;
import com.zcon.mobileris.models.dto.TechnologistTechniquesDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.ITechnologistRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.ITechnologistService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MayuriM
 */
@Service("technologistService")
@Transactional
public class TechnologistServiceImpl implements ITechnologistService,IConvertToDTO,IConvertToBO{
    @Autowired
    ITechnologistRepository technologistRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean deleteTechnologist(int technologistId) {
        return technologistRepository.deleteTechnologist(technologistId);
    }

    @Override
    public List<TechnologistDTO> getAllTechnologist() {
        List<Technologist> tList = technologistRepository.getAllTechnologist();
        List<TechnologistDTO> tDTOList = new ArrayList<>();
        for(Technologist technologist:tList){
            tDTOList.add((TechnologistDTO) _toDTO(technologist));
        }
        return tDTOList;
    }

    @Override
    public TechnologistDTO createTechnologist(TechnologistDTO technologist) {
       Technologist technologistBO = (Technologist) _toBO(technologist);
       return (TechnologistDTO) _toDTO(technologistRepository.createTechnologist(technologistBO));
    }

    @Override
    public TechnologistDTO getTechnologistByTechnologistId(int technologistId) {
         return (TechnologistDTO)_toDTO(technologistRepository.getTechnologistByTechnologistId(technologistId));
    }

    @Override
    public TechnologistDTO updateTechnologist(TechnologistDTO technologist) {
      Technologist technologistBO = (Technologist) _toBO(technologist);
      return (TechnologistDTO) _toDTO(technologistRepository.updateTechnologist(technologistBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Technologist technologist = (Technologist) bo;
        TechnologistDTO dto = modelMapper.map(technologist, TechnologistDTO.class);
//        dto.setCountry(tenant.getCountry().getCountry_id());
//        dto.setState(tenant.getState().getState_id());
          dto.setAddressCountryId(technologist.getCountryObject().getCountry_id());
          dto.setAddressStateId(technologist.getStateObject().getState_id());
        //  dto.setTechnologistSpecialityObject(technologist.getTechnologistSpecialityObject().h);
        return dto;
    }

    @Override
    public Object _toBO(Object dto) {
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        TechnologistDTO technologistDTO = (TechnologistDTO) dto;
        Country country = new Country();
        country.setCountry_id(technologistDTO.getAddressCountryId());//getCountry());
        States state =  new States();
        state.setState_id(technologistDTO.getAddressStateId());//getState());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Technologist technologistBO = modelMapper.map(technologistDTO, Technologist.class);
        technologistBO.setCountryObject(country);
        technologistBO.setStateObject(state);
        
        technologistBO.setCommonComponent(abEntity);
        
        Set<TechnologistSpecialitiesDTO> specialityList = technologistDTO.getTechnologistSpecialityObject();
        Set<TechnologistAvailabilityDTO> avalibilityList = technologistDTO.getTechnologistAvailabilityObject();
        Set<TechnologistTechniquesDTO> techniqueList = technologistDTO.getTechnologistTechniqueObject();
        Set<TechnologistSpecialities> specialityBOList = new HashSet<>();
        Set<TechnologistAvailability> avalibilityBOList = new HashSet<>();
        Set<TechnologistTechniques> techniqueBOList = new HashSet<>();
        for(TechnologistSpecialitiesDTO specialitiesDTO : specialityList){
            TechnologistSpecialities specialities = modelMapper.map (specialitiesDTO,TechnologistSpecialities.class);
            specialities.setCommonComponent(abEntity);
            specialityBOList.add(specialities);
        }
        for(TechnologistAvailabilityDTO avalibilityDTO : avalibilityList){
            TechnologistAvailability avalibities = modelMapper.map (avalibilityDTO,TechnologistAvailability.class);
            avalibities.setCommonComponent(abEntity);
            avalibilityBOList.add(avalibities);
        }
        for(TechnologistTechniquesDTO techniquesDTO : techniqueList){
            TechnologistTechniques techniques = modelMapper.map (techniquesDTO,TechnologistTechniques.class);
            techniques.setCommonComponent(abEntity);
            techniqueBOList.add(techniques);
        }
        technologistBO.setTechnologistSpecialityObject(specialityBOList);
        technologistBO.setTechnologistAvailabilityObject(avalibilityBOList);
        technologistBO.setTechnologistTechniqueObject(techniqueBOList);
        return technologistBO;
    }

}
