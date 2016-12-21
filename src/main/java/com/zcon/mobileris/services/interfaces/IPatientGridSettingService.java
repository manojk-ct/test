/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.PatientGridSettingDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IPatientGridSettingService {
    public List<PatientGridSettingDTO> getAllPatientGridSettings();
    public PatientGridSettingDTO createPatientGridSetting(PatientGridSettingDTO patientGridSetting);
    public PatientGridSettingDTO getPatientGridSettingByPatientGridSettingId(int patientGridSettingId);
    public PatientGridSettingDTO updatePatientGridSetting(PatientGridSettingDTO patientGridSetting);
    public boolean deletePatientGridSetting(int patientGridSettingId);
}
