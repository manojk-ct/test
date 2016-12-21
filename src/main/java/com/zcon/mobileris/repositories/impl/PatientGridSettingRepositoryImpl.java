/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.PatientGridSetting;
import com.zcon.mobileris.repositories.interfaces.IPatientGridSettingRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PradnyaS
 */
@Repository("patientGridSettingRepository")
public class PatientGridSettingRepositoryImpl extends AbstractRepository<Integer, PatientGridSetting> implements IPatientGridSettingRepository{

    @Override
    public List<PatientGridSetting> getAllPatientGridSettings() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("patientGridSettingId")).list();
    }

    @Override
    public PatientGridSetting createPatientGridSetting(PatientGridSetting patientGridSetting) {
        persist(patientGridSetting);
        return patientGridSetting;
    }

    @Override
    public PatientGridSetting getPatientGridSettingByPatientGridSettingId(int patientGridSettingId) {
        return (PatientGridSetting) createCriteria().add(Restrictions.eq("patientGridSettingId", patientGridSettingId)).uniqueResult();
    }

    @Override
    public PatientGridSetting updatePatientGridSetting(PatientGridSetting patientGridSetting) {
        update(patientGridSetting);
        return patientGridSetting;
    }

    @Override
    public boolean deletePatientGridSetting(int patientGridSettingId) {
        boolean result = true;
        PatientGridSetting patientGridSetting = (PatientGridSetting) createCriteria().add(Restrictions.eq("patientGridSettingId", patientGridSettingId)).uniqueResult();
        patientGridSetting.setIsDeleted(result);
        update(patientGridSetting);
        return result;
    }
}
