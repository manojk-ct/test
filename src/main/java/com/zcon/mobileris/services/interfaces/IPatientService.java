package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.Patient;
import com.zcon.mobileris.models.dto.PatientDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IPatientService {
    public List<PatientDTO> getAllPatients();
    public PatientDTO createPatient(PatientDTO patient);
    public PatientDTO getPatientByPatientId(int patient_id);
    public PatientDTO updatePatient(PatientDTO patient);
    public boolean deletePatient(int patient_id);
}
