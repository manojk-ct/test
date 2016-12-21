package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.Radiologist;
import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.models.dto.RadiologistDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.IRadiologistRepository;
import com.zcon.mobileris.services.interfaces.IRadiologistService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ManojK
 */
@Service("radiologistService")
@Transactional
public class RadiologistServiceImpl implements IRadiologistService,IConvertToDTO,IConvertToBO{
   
    @Autowired
    IRadiologistRepository radiologistRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<RadiologistDTO> getAllRadiologists() {
        List<Radiologist> rList = radiologistRepository.getAllRadiologists();
        List<RadiologistDTO> rDTOList = new ArrayList<>();
        for(Radiologist r:rList){
            rDTOList.add((RadiologistDTO) _toDTO(r));
        }
        return rDTOList;
    }

    @Override
    public RadiologistDTO createRadiologist(RadiologistDTO radiologistDTO) {
        Radiologist radiologistBO = (Radiologist) _toBO(radiologistDTO);
        return (RadiologistDTO) _toDTO(radiologistRepository.createRadiologist(radiologistBO));
    }

    @Override
    public RadiologistDTO updateRadiologistById(int radiologistId,RadiologistDTO radiologistDTO) {
        Radiologist radiologistBO = (Radiologist) _toBO(radiologistDTO);
        return (RadiologistDTO) _toDTO(radiologistRepository.updateRadiologistById(radiologistId,radiologistBO));
    }

    @Override
    public RadiologistDTO deleteRadiologistById(int radiologistId) {
        return (RadiologistDTO) _toDTO(radiologistRepository.deleteRadiologistById(radiologistId));
    }

    @Override
    public RadiologistDTO getRadiologistById(int radiologistId) {
        Radiologist r = radiologistRepository.getRadiologistById(radiologistId);
        if(r == null)
            throw new RecordNotFoundException(radiologistId,Radiologist.class.getSimpleName());
        return (RadiologistDTO)_toDTO(r);
    }
    
    @Override
    public Object _toDTO(Object obj)
    {
        Radiologist radiologistBo = (Radiologist) obj;
        
        RadiologistDTO radiologistDTO =  modelMapper.map(radiologistBo, RadiologistDTO.class);        
        radiologistDTO.setRadiologyGroupId(radiologistBo.getRadiologyGroup().getRadiologyGroupId());
        radiologistDTO.setCountryId(radiologistBo.getCountry().getCountry_id());
        radiologistDTO.setStateId(radiologistBo.getState().getState_id());
        
        return radiologistDTO;
    } 
    
    @Override
    public Object _toBO(Object obj) { 
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        RadiologistDTO radiologistDTO = (RadiologistDTO) obj;
        RadiologyGroup group = new RadiologyGroup();
        group.setRadiologyGroupId(radiologistDTO.getRadiologyGroupId());                
        Country country = new Country();
        country.setCountry_id(radiologistDTO.getCountryId());
        States state =  new States();
        state.setState_id(radiologistDTO.getStateId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Radiologist radiologistBO = modelMapper.map(radiologistDTO, Radiologist.class);
        radiologistBO.setRadiologyGroup(group);
        radiologistBO.setCountry(country);
        radiologistBO.setState(state);
        //set created/updated username here while converting DTO to BO
        radiologistBO.setCommonComponent(abEntity);
        return radiologistBO;
    }
}
