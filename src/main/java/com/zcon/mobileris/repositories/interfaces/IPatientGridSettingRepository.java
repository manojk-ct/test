/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.PatientGridSetting;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IPatientGridSettingRepository {
    public List<PatientGridSetting> getAllPatientGridSettings();
    public PatientGridSetting createPatientGridSetting(PatientGridSetting patientGridSetting);
    public PatientGridSetting getPatientGridSettingByPatientGridSettingId(int patientGridSettingId);
    public PatientGridSetting updatePatientGridSetting(PatientGridSetting patientGridSetting);
    public boolean deletePatientGridSetting(int patientGridSettingId);
}
