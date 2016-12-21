/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.entity.CptModifier;
import com.zcon.mobileris.models.dto.CptModifierDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.ICptModifierRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.ICptModifierService;
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
@Service("cptModifierService")
@Transactional
public class CptModifierServiceImpl implements ICptModifierService,IConvertToDTO,IConvertToBO {

    
    @Autowired
    ICptModifierRepository cptModifierRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<CptModifierDTO> getAllCptModifier() {
        List<CptModifier> cList = cptModifierRepository.getAllCptModifier();
        List<CptModifierDTO> cDTOList = new ArrayList<>();
        for(CptModifier cptModifier:cList){
            cDTOList.add((CptModifierDTO) _toDTO(cptModifier));
        }
        return cDTOList;
    }

    @Override
    public CptModifierDTO createCptModifier(CptModifierDTO cptModifier) {
        CptModifier cptModifierBO = (CptModifier) _toBO(cptModifier);
        return (CptModifierDTO) _toDTO(cptModifierRepository.createCptModifier(cptModifierBO));
    }

    @Override
    public CptModifierDTO getCptModifierByCptModifierId(int CptModifierId) {
        return (CptModifierDTO)_toDTO(cptModifierRepository.getCptModifierByCptModifierId(CptModifierId));
    }

    @Override
    public CptModifierDTO updateCptModifier(CptModifierDTO cptModifier) {
        CptModifier cptModifierBO = (CptModifier) _toBO(cptModifier);
        return (CptModifierDTO) _toDTO(cptModifierRepository.updateCptModifier(cptModifierBO));
    }

    @Override
    public boolean deleteCptModifier(int cptModifierId) {
        return cptModifierRepository.deleteCptModifier(cptModifierId);
    }

    @Override
    public Object _toDTO(Object bo) {
        CptModifier cptModifier = (CptModifier) bo;
        CptModifierDTO dto = modelMapper.map(cptModifier, CptModifierDTO.class);
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
        CptModifierDTO cptModifierDTO = (CptModifierDTO) dto;
        CptCode cptCode = new CptCode();
        cptCode.setCptId(cptModifierDTO.getCptId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        
        CptModifier cptModifierBO = modelMapper.map(cptModifierDTO, CptModifier.class);
        cptModifierBO.setCptId(cptCode);
        cptModifierBO.setCommonComponent(abEntity);
        return cptModifierBO;
    }
    
}
