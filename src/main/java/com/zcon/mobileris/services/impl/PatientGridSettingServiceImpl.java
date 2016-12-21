/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.PatientGridSetting;
import com.zcon.mobileris.models.dto.PatientGridSettingDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.IPatientGridSettingRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.IPatientGridSettingService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PradnyaS
 */
@Service("patientGridSettingService")
@Transactional
public class PatientGridSettingServiceImpl implements IPatientGridSettingService,IConvertToDTO,IConvertToBO {

    @Autowired
    IPatientGridSettingRepository patientGridSettingRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<PatientGridSettingDTO> getAllPatientGridSettings() {
        List<PatientGridSetting> pList = patientGridSettingRepository.getAllPatientGridSettings();
        List<PatientGridSettingDTO> pDTOList = new ArrayList<>();
        for(PatientGridSetting patientGridSetting:pList){
            pDTOList.add((PatientGridSettingDTO) _toDTO(patientGridSetting));
        }
        return pDTOList;
    }

    @Override
    public PatientGridSettingDTO createPatientGridSetting(PatientGridSettingDTO patientGridSetting) {
        PatientGridSetting patientGridSettingBO = (PatientGridSetting) _toBO(patientGridSetting);
        return (PatientGridSettingDTO) _toDTO(patientGridSettingRepository.createPatientGridSetting(patientGridSettingBO));
    }

    @Override
    public PatientGridSettingDTO getPatientGridSettingByPatientGridSettingId(int patientGridSettingId) {
        return (PatientGridSettingDTO)_toDTO(patientGridSettingRepository.getPatientGridSettingByPatientGridSettingId(patientGridSettingId));
    }

    @Override
    public PatientGridSettingDTO updatePatientGridSetting(PatientGridSettingDTO patientGridSetting) {
        PatientGridSetting patientGridSettingBO = (PatientGridSetting) _toBO(patientGridSetting);
        return (PatientGridSettingDTO) _toDTO(patientGridSettingRepository.updatePatientGridSetting(patientGridSettingBO));
    }

    @Override
    public boolean deletePatientGridSetting(int patientGridSettingId) {
        return patientGridSettingRepository.deletePatientGridSetting(patientGridSettingId);
    }

    @Override
    public Object _toDTO(Object bo) {
         PatientGridSetting patientGridSetting = (PatientGridSetting) bo;
         PatientGridSettingDTO dto = modelMapper.map(patientGridSetting, PatientGridSettingDTO.class); 
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
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        PatientGridSettingDTO patientGridSettingDTO = (PatientGridSettingDTO) dto;
        PatientGridSetting patientGridSettingBO = modelMapper.map(patientGridSettingDTO, PatientGridSetting.class);
        patientGridSettingBO.setCommonComponent(abEntity);
        return patientGridSettingBO;
    }
    
}
