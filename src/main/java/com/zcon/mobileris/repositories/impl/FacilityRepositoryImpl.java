/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Facilities;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import com.zcon.mobileris.repositories.interfaces.IFacilityRepository;
/**
 *
 * @author PradnyaS
 */
@Repository("facilityRepository")
public class FacilityRepositoryImpl extends AbstractRepository<Integer, Facilities> implements IFacilityRepository{

    @Override
    public List<Facilities> getAllFacilities() {
        List<Facilities> lst = createCriteria().add(Restrictions.eq("isDeleted", false)).setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE ).addOrder(Order.asc("facilityName")).list();
        return lst;
    }

    @Override
    public Facilities getFacilityByFacilityId(int facility_id) {
        return (Facilities) createCriteria().add(Restrictions.eq("facilityId", facility_id)).uniqueResult();
    }

    @Override
    public boolean deleteFacility(int facility_id) {
        boolean result = true;
        Facilities facility = (Facilities) createCriteria().add(Restrictions.eq("facilityId",facility_id)).uniqueResult();
        facility.setIsDeleted(result);
        update(facility);
        return result;
    }

    @Override
    public Facilities createFacility(Facilities facility) {
        persist(facility);
        return facility;
    }

    @Override
    public Facilities updateFacility(Facilities facility) {
        update(facility);
        return facility;
    }

   
}
