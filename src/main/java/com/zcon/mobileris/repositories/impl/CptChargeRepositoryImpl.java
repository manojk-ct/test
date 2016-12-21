/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.CptCharge;
import com.zcon.mobileris.repositories.interfaces.ICptChargeRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PradnyaS
 */
@Repository("cptChargeRepository")
public class CptChargeRepositoryImpl extends AbstractRepository<Integer, CptCharge> implements ICptChargeRepository {
    @Override
    public List<CptCharge> getAllCptCharge(){
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("cptChargeId")).list();
    }

    @Override
    public CptCharge createCptCharge(CptCharge cptCharge){
      persist(cptCharge);
      return cptCharge;
    }

    @Override
    public CptCharge getCptChargeByCptChargeId(int CptChargeId){
      return (CptCharge) createCriteria().add(Restrictions.eq("cptChargeId", CptChargeId)).uniqueResult();
    }

    @Override
    public CptCharge updateCptCharge(CptCharge cptCharge){
      update(cptCharge);
      return cptCharge;
    }

    @Override
    public boolean deleteCptCharge(int cptChargeId){
        boolean result = true;
        CptCharge cptCharge = (CptCharge) createCriteria().add(Restrictions.eq("cptChargeId", cptChargeId)).uniqueResult();
        cptCharge.setIsDeleted(result);
        update(cptCharge);
        return result;
    }
    
}
