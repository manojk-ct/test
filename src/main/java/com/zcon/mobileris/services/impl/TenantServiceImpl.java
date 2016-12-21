package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.entity.Tenant;
import com.zcon.mobileris.models.dto.TenantDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.ITenantRepository;
import com.zcon.mobileris.services.interfaces.ITenantService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("tenantService")
@Transactional
public class TenantServiceImpl implements ITenantService,IConvertToDTO,IConvertToBO {

    @Autowired
    ITenantRepository tenantRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean deleteTenant(int tenant_id) {
        return tenantRepository.deleteTenant(tenant_id);
    }

    @Override
    public List<TenantDTO> getAllTenants() {
        List<Tenant> tList = tenantRepository.getAllTenants();
        List<TenantDTO> tDTOList = new ArrayList<>();
        for(Tenant tenant:tList){
            tDTOList.add((TenantDTO) _toDTO(tenant));
        }
        return tDTOList;
    }

    @Override
    public TenantDTO createTenant(TenantDTO tenant) {
       Tenant tenantBO = (Tenant) _toBO(tenant);
       return (TenantDTO) _toDTO(tenantRepository.createTenant(tenantBO));
    }

    @Override
    public TenantDTO getTenantByTenantId(int tenant_id) {
        return (TenantDTO)_toDTO(tenantRepository.getTenantByTenantId(tenant_id));
    }

    @Override
    public TenantDTO updateTenant(TenantDTO tenant) {
      Tenant tenantBO = (Tenant) _toBO(tenant);
      return (TenantDTO) _toDTO(tenantRepository.updateTenant(tenantBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Tenant tenant = (Tenant) bo;
        TenantDTO dto = modelMapper.map(tenant, TenantDTO.class);
//        dto.setCountry(tenant.getCountry().getCountry_id());
//        dto.setState(tenant.getState().getState_id());
          dto.setCountryId(tenant.getCountry().getCountry_id());
          dto.setStateId(tenant.getState().getState_id());
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
        
        TenantDTO tenantDTO = (TenantDTO) dto;
        Country country = new Country();
        country.setCountry_id(tenantDTO.getCountryId());//getCountry());
        States state =  new States();
        state.setState_id(tenantDTO.getStateId());//getState());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Tenant tenantBO = modelMapper.map(tenantDTO, Tenant.class);
        tenantBO.setCountry(country);
        tenantBO.setState(state);
        
        tenantBO.setCommonComponent(abEntity);
        return tenantBO;
    }

}
