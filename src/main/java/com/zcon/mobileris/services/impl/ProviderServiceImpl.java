
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.entity.Provider;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.dto.ProviderDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import com.zcon.mobileris.services.interfaces.IProviderService;
import com.zcon.mobileris.repositories.interfaces.IProviderRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("newProviderService")
@Transactional
public class ProviderServiceImpl implements IProviderService,IConvertToDTO,IConvertToBO {

    @Autowired
    IProviderRepository newProvierRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public boolean deleteProvider(int provider_id) {
         return newProvierRepository.deleteProvider(provider_id);
    }

    @Override
    public ProviderDTO createProvider(ProviderDTO provider) {
       Provider providerBO = (Provider) _toBO(provider);
       return (ProviderDTO) _toDTO(newProvierRepository.createProvider(providerBO));
    }

    @Override
    public ProviderDTO updateProvider(ProviderDTO provider) {
        Provider providerBO = (Provider) _toBO(provider);
       return (ProviderDTO) _toDTO(newProvierRepository.updateProvider(providerBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Provider provider = (Provider) bo;
        ProviderDTO dto =  new ProviderDTO();//modelMapper.map(provider, ProviderDTO.class);  
        dto.setAddressLine1(provider.getAddressLine1());
        dto.setAddressLine2(provider.getAddressLine2());
        dto.setCity(provider.getCity());
        dto.setCountryId(provider.getCountry().getCountry_id());
        dto.setDegree(provider.getDegree());
        dto.setEmailId(provider.getEmailId());
        dto.setFaxNumber(provider.getFaxNumber());
        dto.setFederalDrugId(provider.getFederalDrugId());
        dto.setFederalTaxId(provider.getFederalTaxId());
        dto.setFirstName(provider.getFirstName());
        dto.setIsDeleted(provider.isIsDeleted());
        dto.setJobDescription(provider.getJobDescription());
        dto.setLastName(provider.getLastName());
        dto.setMiddleName(provider.getMiddleName());
        dto.setMiddleName(provider.getMiddleName());
        dto.setMobileNumber(provider.getMobileNumber());
        dto.setNewcorperxRole(provider.getNewcorperxRole());
        dto.setNpi(provider.getNpi());
        dto.setOrderingStatus(provider.getOrderingStatus());
        dto.setPecosEnrolled(provider.isPecosEnrolled());
        dto.setPhone1(provider.getPhone1());
        dto.setPhone2(provider.getPhone2());
        dto.setPhoneExtension(provider.getPhoneExtension());
        dto.setProviderId(provider.getProviderId());
        dto.setProviderType(provider.getProviderType());
        dto.setSeeAuthorization(provider.isSeeAuthorization());
        dto.setStateId(provider.getState().getState_id());
        dto.setStateLicenseNumber(provider.getStateLicenseNumber());
        dto.setTaxanomyCode(provider.getTaxanomyCode());
        dto.setZipCode(provider.getZipCode());
        dto.setFacilityId(provider.getFacility().getFacilityId());
        //dto.setFacilityId(provider.getFacility().getFacilityId());
        //dto.setCountryId(provider.getCountry().getCountry_id());
        //dto.setStateId(provider.getState().getState_id());
        return dto;
    }

    @Override
    public List<ProviderDTO> getAllProvider() {
        List<Provider> pList = newProvierRepository.getAllProvider();
        List<ProviderDTO> pDTOList = new ArrayList<>();
        for(Provider provider:pList){
            pDTOList.add((ProviderDTO) _toDTO(provider));
        }
        return pDTOList;
    }

    @Override
    public ProviderDTO getProviderByProviderId(int provider_id) {
        return (ProviderDTO) _toDTO(newProvierRepository.getProviderByProviderId(provider_id));
    }

    @Override
    public Object _toBO(Object dto) {
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        ProviderDTO providerDTO = (ProviderDTO) dto;
        Facilities facility = new Facilities();
        facility.setFacilityId(providerDTO.getFacilityId());
        Country country = new Country();
        country.setCountry_id(providerDTO.getCountryId());
        States state =  new States();
        state.setState_id(providerDTO.getStateId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        
        Provider providerBO = modelMapper.map(providerDTO, Provider.class);
        providerBO.setFacility(facility);
        providerBO.setCountry(country);
        providerBO.setState(state);
        providerBO.setCommonComponent(abEntity);
        return providerBO;
    }
}
