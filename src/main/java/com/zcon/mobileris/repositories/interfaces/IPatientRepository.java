package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Patient;
import com.zcon.mobileris.models.dto.PatientDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IPatientRepository {

    public List<Patient> getAllPatients();
    public Patient createPatient(Patient patient);
    public Patient getPatientByPatientId(int patient_id);
    public Patient updatePatient(Patient patient);
    public boolean deletePatient(int patient_id);
}
