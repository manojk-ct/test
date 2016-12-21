/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.BodyPartExam;
import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.entity.Cpt_Time;
import com.zcon.mobileris.models.dto.CptCodeDTO;
import com.zcon.mobileris.models.dto.Cpt_TimeDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.ICptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.ICptRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("cptService")
@Transactional 
public class CptServiceImpl implements ICptService,IConvertToDTO,IConvertToBO {

    @Autowired
    ICptRepository cptRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CptCodeDTO> findAllCptCodes() {
        List<CptCode> cList = cptRepository.findAllCptCodes();
        List<CptCodeDTO> cDTOList = new ArrayList<>();
        for(CptCode cpt:cList){
            cDTOList.add((CptCodeDTO) _toDTO(cpt));
        }
        return cDTOList;
    }

    @Override
    public CptCodeDTO createCpt(CptCodeDTO cpt) {
       CptCode cptBO = (CptCode) _toBO(cpt);
       return (CptCodeDTO) _toDTO(cptRepository.createCpt(cptBO));
    }

    @Override
    public CptCodeDTO findCptCodeByCptCodeId(int cptId) {
        return (CptCodeDTO)_toDTO(cptRepository.findCptCodeByCptCodeId(cptId));
    }

    @Override
    public CptCodeDTO updateCptCode(CptCodeDTO cpt) {
        CptCode cptBO = (CptCode) _toBO(cpt);
        return (CptCodeDTO) _toDTO(cptRepository.updateCptCode(cptBO));
    }

    @Override
    public boolean deleteCptCode(int cptId) {
        return cptRepository.deleteCptCode(cptId);
    }

    @Override
    public Object _toDTO(Object bo) {
       
        CptCode cptCodeBO = (CptCode) bo;
        
        CptCodeDTO cptCodeDTO = modelMapper.map(cptCodeBO, CptCodeDTO.class);
        cptCodeDTO.setBodyPartExamId(cptCodeBO.getBodyPartExam().getBodyPartExamId());
        
        return cptCodeDTO;
    }

    @Override
    public Object _toBO(Object dto) {
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        CptCodeDTO cptCodeDTO = (CptCodeDTO) dto;
       
        BodyPartExam exam = new BodyPartExam();
        exam.setBodyPartExamId(cptCodeDTO.getBodyPartExamId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        CptCode cptBO = modelMapper.map(cptCodeDTO, CptCode.class);
        
        cptBO.setBodyPartExam(exam);
        cptBO.setCommonComponent(abEntity);
        
        Set<Cpt_TimeDTO> cpt_timeDTOList = cptCodeDTO.getCptTimeObject();
        Set<Cpt_Time> cptTimeBOList = new HashSet<>();

        for (Cpt_TimeDTO timeDTO : cpt_timeDTOList) {
            Cpt_Time times = modelMapper.map(timeDTO, Cpt_Time.class);
            times.setCommonComponent(abEntity);
            cptTimeBOList.add(times);
        }

        cptBO.setCptTimeObject(cptTimeBOList);
        
        return cptBO;
    }
    
}
