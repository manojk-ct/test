package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Patient;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IPatientRepository;

/**
 *
 * @author PradnyaS
 */
@Repository("PatientRepository")
public class PatientRepositoryImpl extends AbstractRepository<Integer, Patient> implements IPatientRepository{

    @Override
    public List<Patient> getAllPatients() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("firstName")).list();
    }

    @Override
    public Patient getPatientByPatientId(int patient_id) {
        return (Patient) createCriteria().add(Restrictions.eq("patientId", patient_id)).uniqueResult();
    }

    @Override
    public boolean deletePatient(int patient_id) {
        boolean result = true;
        Patient patient = (Patient) createCriteria().add(Restrictions.eq("patientId", patient_id)).uniqueResult();
        patient.setIsDeleted(result);;
        update(patient);
        return result;
    }

    @Override
    public Patient createPatient(Patient patient) {
        persist(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        update(patient);
        return patient;
    }
}
