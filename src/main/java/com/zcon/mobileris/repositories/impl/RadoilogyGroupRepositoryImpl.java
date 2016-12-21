/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.repositories.interfaces.IRadiologyGroupRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PradnyaS
 */
@Repository("radiolgyGroupRepository")
public class RadoilogyGroupRepositoryImpl extends AbstractRepository<Integer, RadiologyGroup> implements IRadiologyGroupRepository{

    @Override
    public List<RadiologyGroup> getAllRadiologyGroup() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("groupName")).list();
    }

    @Override
    public RadiologyGroup createRadiologist(RadiologyGroup radiologyGroup) {
        persist(radiologyGroup);
        return radiologyGroup;
    }

    @Override
    public RadiologyGroup updateRadiologyGroupById(RadiologyGroup radiologyGroup) {
        update(radiologyGroup);
        return radiologyGroup;
    }

    @Override
    public boolean deleteRadiologyGroupById(int radiologyGroupId) {
        boolean result = true;
        RadiologyGroup group = (RadiologyGroup) createCriteria().add(Restrictions.eq("radiologyGroupId", radiologyGroupId)).uniqueResult();
        group.setIsDeleted(result);
        update(group);
        return result;
    }

    @Override
    public RadiologyGroup getRadiologyGroupById(int radiologyGroupId) {
        return (RadiologyGroup) createCriteria().add(Restrictions.eq("radiologyGroupId", radiologyGroupId)).uniqueResult();
    }
    
}
