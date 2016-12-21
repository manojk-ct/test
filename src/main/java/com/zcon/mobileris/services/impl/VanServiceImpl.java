/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Van;
import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.models.dto.VanDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IVanService;
import com.zcon.mobileris.repositories.interfaces.IVanRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PravinP
 */
@Service("vanService")
@Transactional
public class VanServiceImpl implements IVanService,IConvertToBO,IConvertToDTO{
    
    @Autowired
    IVanRepository vanDetailsRepositiry;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<VanDTO> getAllVanDetails() {
        List<Van> vList = vanDetailsRepositiry.getAllVANDetails();
        List<VanDTO> vDTOList = new ArrayList<>();
        for(Van v:vList){
            vDTOList.add((VanDTO) _toDTO(v));
        }
        return vDTOList;
    }
    
    @Override
    public VanDTO createVANDetails(VanDTO vanDetails){
        Van vanDetailsBO = (Van) _toBO(vanDetails);
        return (VanDTO) _toDTO(vanDetailsRepositiry.createVANDetails(vanDetailsBO));
    }
    
    @Override
    public VanDTO updateVANDetailsById(int vanDetailId,VanDTO vanDetails){
        Van vanDetailsBO = (Van) _toBO(vanDetails);
        return (VanDTO) _toDTO(vanDetailsRepositiry.updateVANDetailsById(vanDetailId, vanDetailsBO));
    }
    
    @Override
    public VanDTO deleteVANDetailsById(int vanDetailId){
        return (VanDTO) _toDTO(vanDetailsRepositiry.deleteVANDetailsById(vanDetailId));
    }
    
    @Override
    public VanDTO getVANDetailsById(int vanDetailId){
        Van v = vanDetailsRepositiry.getVANDetailsById(vanDetailId);
        if(v == null)
            throw new RecordNotFoundException(vanDetailId, Van.class.getSimpleName());
        return (VanDTO) _toDTO(v);
    }
    
    
    @Override
    public Object _toDTO(Object obj)
    {
        Van vandetailsBO = (Van) obj;
        VanDTO vanDetailDTO = modelMapper.map(vandetailsBO, VanDTO.class);
        return vanDetailDTO;
    }
    
     @Override
    public Object _toBO(Object obj) { 
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        VanDTO vanDetailsDTO = (VanDTO) obj;
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        Van vanDetailsBO = modelMapper.map(vanDetailsDTO, Van.class);
        vanDetailsBO.setCommonComponent(abEntity);
        return vanDetailsBO;
    }
}
