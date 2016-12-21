/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.RequisitionGridSetting;
import com.zcon.mobileris.models.dto.RequisitionGridSettingDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.IRequisitionGridSettingRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IRequisitionGridSettingService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("requisitionGridSettingService")
@Transactional
public class RequisitionGridSettingServiceImpl implements IRequisitionGridSettingService,IConvertToDTO,IConvertToBO {
    
    @Autowired
    IRequisitionGridSettingRepository requisitionGridSettingRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<RequisitionGridSettingDTO> getAllRequisitionGridSettings() {
        List<RequisitionGridSetting> rList = requisitionGridSettingRepository.getAllRequisitionGridSettings();
        List<RequisitionGridSettingDTO> rDTOList = new ArrayList<>();
        for(RequisitionGridSetting requisitionGridSetting:rList){
            rDTOList.add((RequisitionGridSettingDTO) _toDTO(requisitionGridSetting));
        }
        return rDTOList;
    }

    @Override
    public RequisitionGridSettingDTO createRequisitionGridSetting(RequisitionGridSettingDTO requisitionGridSetting) {
        RequisitionGridSetting requisitionGridSettingBO = (RequisitionGridSetting) _toBO(requisitionGridSetting);
        return (RequisitionGridSettingDTO) _toDTO(requisitionGridSettingRepository.createRequisitionGridSetting(requisitionGridSettingBO));
    }

    @Override
    public RequisitionGridSettingDTO getRequisitionGridSettingByRequisitionGridSettingId(int requisitionGridSettingId) {
        return (RequisitionGridSettingDTO)_toDTO(requisitionGridSettingRepository.getRequisitionGridSettingByRequisitionGridSettingId(requisitionGridSettingId));
    }

    @Override
    public RequisitionGridSettingDTO updateRequisitionGridSetting(RequisitionGridSettingDTO requisitionGridSetting) {
        RequisitionGridSetting requisitionGridSettingBO = (RequisitionGridSetting) _toBO(requisitionGridSetting);
        return (RequisitionGridSettingDTO) _toDTO(requisitionGridSettingRepository.updateRequisitionGridSetting(requisitionGridSettingBO));
    }

    @Override
    public boolean deleteRequisitionGridSetting(int requisitionGridSettingId) {
        return requisitionGridSettingRepository.deleteRequisitionGridSetting(requisitionGridSettingId);
    }

    @Override
    public Object _toDTO(Object bo) {
         RequisitionGridSetting requisitionGridSetting = (RequisitionGridSetting) bo;
         RequisitionGridSettingDTO dto = modelMapper.map(requisitionGridSetting, RequisitionGridSettingDTO.class); 
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
        RequisitionGridSettingDTO requisitionGridSettingDTO = (RequisitionGridSettingDTO) dto;
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        RequisitionGridSetting requisitionGridSettingBO = modelMapper.map(requisitionGridSettingDTO, RequisitionGridSetting.class);
        requisitionGridSettingBO.setCommonComponent(abEntity);
        return requisitionGridSettingBO;
    }
    
}
