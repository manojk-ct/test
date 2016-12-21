/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.RequisitionGridSettingDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IRequisitionGridSettingService {
    public List<RequisitionGridSettingDTO> getAllRequisitionGridSettings();
    public RequisitionGridSettingDTO createRequisitionGridSetting(RequisitionGridSettingDTO requisitionGridSetting);
    public RequisitionGridSettingDTO getRequisitionGridSettingByRequisitionGridSettingId(int requisitionGridSettingId);
    public RequisitionGridSettingDTO updateRequisitionGridSetting(RequisitionGridSettingDTO requisitionGridSetting);
    public boolean deleteRequisitionGridSetting(int requisitionGridSettingId);
}
