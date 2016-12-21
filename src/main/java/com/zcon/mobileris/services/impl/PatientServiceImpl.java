package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.Patient;
import com.zcon.mobileris.entity.Patient_Insurance;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.dto.PatientDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IPatientService;
import com.zcon.mobileris.repositories.interfaces.IPatientRepository;
import java.util.Date;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author PradnyaS
 */
@Service("patientService")
@Transactional
public class PatientServiceImpl implements IPatientService ,IConvertToDTO,IConvertToBO{

    @Autowired
    IPatientRepository patientRepository;
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean deletePatient(int patient_id) {
        return patientRepository.deletePatient(patient_id);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> pList = patientRepository.getAllPatients();
        List<PatientDTO> pDTOList = new ArrayList<>();
        for(Patient patient:pList){
            pDTOList.add((PatientDTO) _toDTO(patient));
        }
        return pDTOList;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patient) {
        Patient patientBO = (Patient) _toBO(patient);
        return (PatientDTO) _toDTO(patientRepository.createPatient(patientBO));
    }

    @Override
    public PatientDTO getPatientByPatientId(int patient_id) {
        return (PatientDTO) _toDTO(patientRepository.getPatientByPatientId(patient_id));
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patient) {
       Patient patientBO = (Patient) _toBO(patient);
       return (PatientDTO) _toDTO(patientRepository.updatePatient(patientBO));
    }

    @Override
    public Object _toDTO(Object bo) {
        Patient patientBO = (Patient) bo;
        PatientDTO dto = modelMapper.map(patientBO, PatientDTO.class);
        dto.setStateId(patientBO.getState().getState_id());
        dto.setCountryId(patientBO.getCountry().getCountry_id());
        
       // insurance = (Patient_Insurance) patientBO.getInsurance();
        //dto.setInsurance((Set<Patient_Insurance>) insurance);
        //Payer p= new Payer();
       // p.setPayerId(dto.getInsurance().);
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
        PatientDTO patientDTO = (PatientDTO) dto;
        Country country = new Country();
        country.setCountry_id(patientDTO.getCountryId());
        States state =  new States();
        state.setState_id(patientDTO.getStateId());
        //Set<Patient_Insurance> insurance = patientDTO.getInsurance();
        Patient_Insurance insurance = new Patient_Insurance();
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        //insurance.setCreatedDateTime(date);
        //insurance.setUpdatedDateTime(date);
        
        Patient patientBO = modelMapper.map(patientDTO, Patient.class);
        patientBO.setCountry(country);
        patientBO.setState(state);
        patientBO.setInsurance((Set<Patient_Insurance>) insurance);
        patientBO.setCommonComponent(abEntity);
        //patientBO.setCreatedDateTime(date);
        //patientBO.setUpdatedDateTime(date);
        return patientBO;
    }

}
