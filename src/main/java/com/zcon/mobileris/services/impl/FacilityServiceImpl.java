/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.entity.Facility_Contacts;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.dto.FacilitiesDTO;
import com.zcon.mobileris.models.dto.Facility_ContactsDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import com.zcon.mobileris.services.interfaces.IFacilityService;
import com.zcon.mobileris.repositories.interfaces.IFacilityRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("facilityService")
@Transactional
public class FacilityServiceImpl implements IFacilityService, IConvertToDTO, IConvertToBO {

    @Autowired
    IFacilityRepository facilityRepository;

    @Autowired
    MailService mailService;
    
    @Autowired
    ModelMapper modelMapper;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    
    @Override
    public boolean deleteFacility(int facility_id) {
        return facilityRepository.deleteFacility(facility_id);
       
    }

    @Override
    public FacilitiesDTO createFacility(FacilitiesDTO facility) {
        Facilities facilityBO = (Facilities) _toBO(facility);
        return (FacilitiesDTO) _toDTO(facilityRepository.createFacility(facilityBO));
    }

    @Override
    public FacilitiesDTO updateFacility(FacilitiesDTO facility) {
        Facilities facilityBO = (Facilities) _toBO(facility);
        return (FacilitiesDTO) _toDTO(facilityRepository.updateFacility(facilityBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Facilities facilitiesBo = (Facilities) bo;

        FacilitiesDTO facilitiesDTO = modelMapper.map(facilitiesBo, FacilitiesDTO.class);
        facilitiesDTO.setDispatchRegionId(facilitiesBo.getDispatchRegion().getDispatch_region_id());
        facilitiesDTO.setServiceCountryId(facilitiesBo.getServiceCountry().getCountry_id());
        facilitiesDTO.setServiceStateId(facilitiesBo.getServiceState().getState_id());
        facilitiesDTO.setBillingCountryId(facilitiesBo.getBillingCountry().getCountry_id());
        facilitiesDTO.setBillingStateId(facilitiesBo.getBillingState().getState_id());

//        for(Facility_Contacts contact: facilitiesBo.getContacts())
//        {
//            facilitiesDTO.setContacts((Set<Facility_ContactsDTO>) contact);
//        }
        return facilitiesDTO;
    }

    @Override
    public List<FacilitiesDTO> getAllFacilities() {
        List<Facilities> fList = facilityRepository.getAllFacilities();
        
        List<FacilitiesDTO> fDTOList = new ArrayList<>();
        for (Facilities facility : fList) {
            fDTOList.add((FacilitiesDTO) _toDTO(facility));
        }
        return fDTOList;
    }

    @Override
    public FacilitiesDTO getFacilityByFacilityId(int facility_id) {
        mailService.sendMail("sutkar.pradnya23@gmail.com", "Change Password", "hi");
        return (FacilitiesDTO) _toDTO(facilityRepository.getFacilityByFacilityId(facility_id));
    }

    @Override
    public Object _toBO(Object dto) {
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        FacilitiesDTO facilitiesDTO = (FacilitiesDTO) dto;
        DispatchRegions dispatchRegion = new DispatchRegions();
        dispatchRegion.setDispatch_region_id(facilitiesDTO.getDispatchRegionId());
        Country serviceCountry = new Country();
        serviceCountry.setCountry_id(facilitiesDTO.getServiceCountryId());
        States serviceState = new States();
        serviceState.setState_id(facilitiesDTO.getServiceStateId());
        Country billingCountry = new Country();
        billingCountry.setCountry_id(facilitiesDTO.getBillingCountryId());
        States billingState = new States();
        billingState.setState_id(facilitiesDTO.getBillingStateId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Facilities facilityBO = modelMapper.map(facilitiesDTO, Facilities.class);

        facilityBO.setDispatchRegion(dispatchRegion);
        facilityBO.setServiceCountry(serviceCountry);
        facilityBO.setServiceState(serviceState);
        facilityBO.setBillingCountry(billingCountry);
        facilityBO.setBillingState(billingState);
        facilityBO.setCommonComponent(abEntity);

        //convert facility contat dto to BO as well
        Set<Facility_ContactsDTO> facility_contactsDTOList = facilitiesDTO.getContacts();
        Set<Facility_Contacts> facilityContactsBOList = new HashSet<>();

        for (Facility_ContactsDTO contactDTO : facility_contactsDTOList) {
            Facility_Contacts facilityContacts = modelMapper.map(contactDTO, Facility_Contacts.class);
            facilityContacts.setCommonComponent(abEntity);
            facilityContactsBOList.add(facilityContacts);
        }

        facilityBO.setContacts(facilityContactsBOList);
        return facilityBO;
    }
}
