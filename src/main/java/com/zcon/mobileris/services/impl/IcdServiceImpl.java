/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.IcdCode;
import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.models.dto.IcdCodeDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.repositories.interfaces.IIcdRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import com.zcon.mobileris.services.interfaces.IIcdService;
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
 * @author MayuriM
 */
@Service("icdService")
@Transactional
public class IcdServiceImpl implements IIcdService,IConvertToBO,IConvertToDTO{
    
    @Autowired
    IIcdRepository icdRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<IcdCodeDTO> findAllIcdCodes() {
        List<IcdCode> iList = icdRepository.findAllIcdCodes();
        List<IcdCodeDTO> iDTOList = new ArrayList<>();
        for(IcdCode i:iList){
            iDTOList.add((IcdCodeDTO) _toDTO(i));
        }
        return iDTOList;
    }
    
    @Override
    public IcdCodeDTO createIcd(IcdCodeDTO icdCode) {
        IcdCode icdBO = (IcdCode) _toBO(icdCode);
        return (IcdCodeDTO) _toDTO(icdRepository.createIcd(icdBO));
    }

    @Override
    public IcdCodeDTO findIcdCodeByIcdCodeId(int IcdId) {
        IcdCode icd = icdRepository.findIcdCodeByIcdCodeId(IcdId);
        if(icd == null)
            throw new RecordNotFoundException(IcdId, IcdCode.class.getSimpleName());
        return (IcdCodeDTO) _toDTO(icd);
    }

    @Override
    public IcdCodeDTO updateIcdCode(IcdCodeDTO icdCode) {
        IcdCode icdBO = (IcdCode) _toBO(icdCode);
        return (IcdCodeDTO) _toDTO(icdRepository.updateIcdCode(icdBO));
    }

    @Override
    public boolean deleteIcdCode(int IcdId) {
        return icdRepository.deleteIcdCode(IcdId);
    }
    
    @Override
    public Object _toDTO(Object obj){
        IcdCode icdBO = (IcdCode) obj;
        IcdCodeDTO icdDTO = modelMapper.map(icdBO, IcdCodeDTO.class);
        return icdDTO;
    }
    
    @Override
    public Object _toBO(Object obj){
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        IcdCodeDTO icdDTO = (IcdCodeDTO) obj;
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        IcdCode icdBO = modelMapper.map(icdDTO, IcdCode.class);
        icdBO.setCommonComponent(abEntity);
        return icdBO;
    }
}