/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Affiliate;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.entity.Tenant;
import com.zcon.mobileris.models.dto.AffiliateDTO;
import com.zcon.mobileris.repositories.interfaces.IAffiliateRepository;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IAffiliateService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author MayuriM
 */
@Service("affiliateService")
@Transactional
public class AffiliateServiceImpl implements IAffiliateService,IConvertToDTO,IConvertToBO{
    
    @Autowired
    IAffiliateRepository affiliateRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean deleteAffiliate(int affialiateId) {
        return affiliateRepository.deleteAffiliate(affialiateId);
    }

    @Override
    public List<AffiliateDTO> getAllAffiliates() {
        List<Affiliate> tList = affiliateRepository.getAllAffiliates();
        List<AffiliateDTO> tDTOList = new ArrayList<>();
        for(Affiliate affiliates:tList){
            tDTOList.add((AffiliateDTO) _toDTO(affiliates));
        }
        return tDTOList;
    }

    @Override
    public AffiliateDTO createAffiliate(AffiliateDTO affiliates) {
       Affiliate affiliatesBO = (Affiliate) _toBO(affiliates);
       return (AffiliateDTO) _toDTO(affiliateRepository.createAffiliate(affiliatesBO));
    }

    @Override
    public AffiliateDTO getAffiliateByAffiliateId(int affialiateId) {
         return (AffiliateDTO)_toDTO(affiliateRepository.getAffiliateByAffiliateId(affialiateId));
    }

    @Override
    public AffiliateDTO updateAffiliate(AffiliateDTO affiliates) {
      Affiliate affiliatesBO = (Affiliate) _toBO(affiliates);
      return (AffiliateDTO) _toDTO(affiliateRepository.updateAffiliate(affiliatesBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Affiliate affiliates = (Affiliate) bo;
        AffiliateDTO dto = modelMapper.map(affiliates, AffiliateDTO.class);
//        dto.setCountry(tenant.getCountry().getCountry_id());
//        dto.setState(tenant.getState().getState_id());
          dto.setContactCountryId(affiliates.getCountry().getCountry_id());
          dto.setContactStateId(affiliates.getState().getState_id());
          dto.setDispatchRegionId(affiliates.getDispatchRegion().getDispatch_region_id());
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
        AffiliateDTO affiliatesDTO = (AffiliateDTO) dto;
        Country country = new Country();
        country.setCountry_id(affiliatesDTO.getContactCountryId());//getCountry());
        States state =  new States();
        state.setState_id(affiliatesDTO.getContactStateId());//getState());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        DispatchRegions region = new DispatchRegions();
        region.setDispatch_region_id(affiliatesDTO.getDispatchRegionId());
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Affiliate affiliatesBO = modelMapper.map(affiliatesDTO, Affiliate.class);
        affiliatesBO.setCountry(country);
        affiliatesBO.setState(state);
        affiliatesBO.setDispatchRegion(region);
        affiliatesBO.setCommonComponent(abEntity);
        return affiliatesBO;
    }

}
