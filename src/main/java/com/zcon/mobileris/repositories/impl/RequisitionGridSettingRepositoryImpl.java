/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.RequisitionGridSetting;
import com.zcon.mobileris.repositories.interfaces.IRequisitionGridSettingRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PradnyaS
 */
@Repository("requisitionGridSettingRepository")
public class RequisitionGridSettingRepositoryImpl extends AbstractRepository<Integer, RequisitionGridSetting> implements IRequisitionGridSettingRepository{

    @Override
    public List<RequisitionGridSetting> getAllRequisitionGridSettings() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("requisitionGridSettingId")).list();
    }

    @Override
    public RequisitionGridSetting createRequisitionGridSetting(RequisitionGridSetting requisitionGridSetting) {
        persist(requisitionGridSetting);
        return requisitionGridSetting;
    }

    @Override
    public RequisitionGridSetting getRequisitionGridSettingByRequisitionGridSettingId(int requisitionGridSettingId) {
        return (RequisitionGridSetting) createCriteria().add(Restrictions.eq("requisitionGridSettingId", requisitionGridSettingId)).uniqueResult();
    }

    @Override
    public RequisitionGridSetting updateRequisitionGridSetting(RequisitionGridSetting requisitionGridSetting) {
        update(requisitionGridSetting);
        return requisitionGridSetting;
    }

    @Override
    public boolean deleteRequisitionGridSetting(int requisitionGridSettingId) {
         boolean result = true;
        RequisitionGridSetting requisitionGridSetting = (RequisitionGridSetting) createCriteria().add(Restrictions.eq("requisitionGridSettingId", requisitionGridSettingId)).uniqueResult();
        requisitionGridSetting.setIsDeleted(result);
        update(requisitionGridSetting);
        return result;
    }
    
}
