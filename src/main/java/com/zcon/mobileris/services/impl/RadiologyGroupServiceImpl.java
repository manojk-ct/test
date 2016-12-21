/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.models.dto.RadiologyGroupDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.IRadiologyGroupRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.IRadiologyGroupService;
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
@Service("radiologyGroupService")
@Transactional
public class RadiologyGroupServiceImpl implements IConvertToDTO,IConvertToBO,IRadiologyGroupService{
    
    @Autowired
    IRadiologyGroupRepository groupRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Object _toDTO(Object bo) {
        RadiologyGroup groupBO = (RadiologyGroup) bo;
        RadiologyGroupDTO groupDTO = modelMapper.map(groupBO, RadiologyGroupDTO.class);
        return groupDTO;
    }

    @Override
    public Object _toBO(Object dto) {
       String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        RadiologyGroupDTO groupDTO = (RadiologyGroupDTO) dto;
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        RadiologyGroup groupBO = modelMapper.map(groupDTO, RadiologyGroup.class);
        groupBO.setCommonComponent(abEntity);
        return groupBO;
    }

    @Override
    public List<RadiologyGroupDTO> getAllRadiologyGroup() {
        List<RadiologyGroup> groupList = groupRepository.getAllRadiologyGroup();
        List<RadiologyGroupDTO> gDTOList = new ArrayList<>();
        for(RadiologyGroup group:groupList){
            gDTOList.add((RadiologyGroupDTO) _toDTO(group));
        }
        return gDTOList;
    }

    @Override
    public RadiologyGroupDTO createRadiologist(RadiologyGroupDTO radiologyGroup) {
       RadiologyGroup groupBO = (RadiologyGroup) _toBO(radiologyGroup);
       return (RadiologyGroupDTO) _toDTO(groupRepository.createRadiologist(groupBO));
    }

    @Override
    public RadiologyGroupDTO updateRadiologyGroupById(RadiologyGroupDTO radiologyGroup) {
       RadiologyGroup groupBO = (RadiologyGroup) _toBO(radiologyGroup);
       return (RadiologyGroupDTO) _toDTO(groupRepository.updateRadiologyGroupById(groupBO));
    }

    @Override
    public boolean deleteRadiologyGroupById(int radiologyGroupId) {
       return groupRepository.deleteRadiologyGroupById(radiologyGroupId);
    }

    @Override
    public RadiologyGroupDTO getRadiologyGroupById(int radiologyGroupId) {
        return (RadiologyGroupDTO)_toDTO(groupRepository.getRadiologyGroupById(radiologyGroupId));
    }
    
}
