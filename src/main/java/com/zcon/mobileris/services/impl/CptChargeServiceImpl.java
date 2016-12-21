/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.CptCharge;
import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.dto.CptChargeDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.ICptChargeRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.ICptChargeService;
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
@Service("cptChargeService")
@Transactional
public class CptChargeServiceImpl implements ICptChargeService,IConvertToDTO,IConvertToBO {

    @Autowired
    ICptChargeRepository cptChargeRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<CptChargeDTO> getAllCptCharge() {
        List<CptCharge> cList = cptChargeRepository.getAllCptCharge();
        List<CptChargeDTO> cDTOList = new ArrayList<>();
        for(CptCharge cptCharge:cList){
            cDTOList.add((CptChargeDTO) _toDTO(cptCharge));
        }
        return cDTOList;
    }

    @Override
    public CptChargeDTO createCptCharge(CptChargeDTO cptCharge) {
        CptCharge cptChargeBO = (CptCharge) _toBO(cptCharge);
        return (CptChargeDTO) _toDTO(cptChargeRepository.createCptCharge(cptChargeBO));
    }

    @Override
    public CptChargeDTO getCptChargeByCptChargeId(int CptChargeId) {
        return (CptChargeDTO)_toDTO(cptChargeRepository.getCptChargeByCptChargeId(CptChargeId));
    }

    @Override
    public CptChargeDTO updateCptCharge(CptChargeDTO cptCharge) {
        CptCharge cptChargeBO = (CptCharge) _toBO(cptCharge);
        return (CptChargeDTO) _toDTO(cptChargeRepository.updateCptCharge(cptChargeBO));
    }

    @Override
    public boolean deleteCptCharge(int cptChargeId) {
        return cptChargeRepository.deleteCptCharge(cptChargeId);
    }

    @Override
    public Object _toDTO(Object bo) {
        CptCharge cptChargeBO = (CptCharge) bo;
        CptChargeDTO dto = modelMapper.map(cptChargeBO, CptChargeDTO.class);
        dto.setCptChargeId(cptChargeBO.getCptObject().getCptId());
        dto.setPayer_Id(cptChargeBO.getPayerObject().getPayerId());
        dto.setStateId(cptChargeBO.getStateObject().getState_id());
        dto.setDispatchRegionId(cptChargeBO.getDispatchRegionObject().getDispatch_region_id());
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
        CptChargeDTO cptChargeDTO = (CptChargeDTO) dto;
        CptCode cptCode = new CptCode();
        cptCode.setCptId(cptChargeDTO.getCpt_Id());
        Payer payer = new Payer();
        payer.setPayerId(cptChargeDTO.getPayer_Id());
        States state = new States();
        state.setState_id(cptChargeDTO.getStateId());
        DispatchRegions region = new DispatchRegions();
        region.setDispatch_region_id(cptChargeDTO.getDispatchRegionId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        CptCharge cptChargeBO = modelMapper.map(cptChargeDTO, CptCharge.class);
        cptChargeBO.setCptObject(cptCode);
        cptChargeBO.setPayerObject(payer);
        cptChargeBO.setStateObject(state);
        cptChargeBO.setDispatchRegionObject(region);
        cptChargeBO.setCommonComponent(abEntity);
        return cptChargeBO;
    }
    
}
