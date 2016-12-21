/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.RequisitionGridSetting;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IRequisitionGridSettingRepository {
    public List<RequisitionGridSetting> getAllRequisitionGridSettings();
    public RequisitionGridSetting createRequisitionGridSetting(RequisitionGridSetting requisitionGridSetting);
    public RequisitionGridSetting getRequisitionGridSettingByRequisitionGridSettingId(int requisitionGridSettingId);
    public RequisitionGridSetting updateRequisitionGridSetting(RequisitionGridSetting requisitionGridSetting);
    public boolean deleteRequisitionGridSetting(int requisitionGridSettingId);
}
