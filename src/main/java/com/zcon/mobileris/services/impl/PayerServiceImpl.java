/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.dto.PayerDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import com.zcon.mobileris.services.interfaces.IPayerService;
import com.zcon.mobileris.repositories.interfaces.IPayerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("newPayerService")
@Transactional
public class PayerServiceImpl implements IPayerService ,IConvertToDTO,IConvertToBO {

    @Autowired
    IPayerRepository newPayerRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean deletePayer(int payer_id) {
        return newPayerRepository.deletePayer(payer_id);
    }

    @Override
    public List<PayerDTO> getAllPayer() {
        List<Payer> pList = newPayerRepository.getAllPayer();
        List<PayerDTO> pDTOList = new ArrayList<>();
        for(Payer payer:pList){
            pDTOList.add((PayerDTO) _toDTO(payer));
        }
        return pDTOList;
    }

    @Override
    public PayerDTO createPayer(PayerDTO payer) {
       Payer payerBO = (Payer) _toBO(payer);
       return (PayerDTO) _toDTO(newPayerRepository.createPayer(payerBO));
    }

    @Override
    public PayerDTO getPayerByPayerId(int payer_id) {
        return (PayerDTO)_toDTO(newPayerRepository.getPayerByPayerId(payer_id));
    }

    @Override
    public PayerDTO updatePayer(PayerDTO payer) {
        Payer payerBO = (Payer) _toBO(payer);
       return (PayerDTO) _toDTO(newPayerRepository.updatePayer(payerBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Payer payer = (Payer) bo;
        
        PayerDTO dto=modelMapper.map(payer, PayerDTO.class);
        dto.setCountryId(payer.getCountry().getCountry_id());
        dto.setStateId(payer.getState().getState_id());
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
        PayerDTO payerDTO = (PayerDTO) dto;
        Country country1 = new Country();
        country1.setCountry_id(payerDTO.getCountryId());
        States state1 =  new States();
        state1.setState_id(payerDTO.getStateId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Payer payerBO = modelMapper.map(payerDTO, Payer.class);
        payerBO.setCountry(country1);
        payerBO.setState(state1);
        payerBO.setCommonComponent(abEntity);
        return payerBO;
    }

}
