/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.CptModifier;
import com.zcon.mobileris.repositories.interfaces.ICptModifierRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PradnyaS
 */
@Repository("cptModifierRepository")
public class CptModifierRepositoryImpl extends AbstractRepository<Integer, CptModifier> implements ICptModifierRepository {
    @Override
    public List<CptModifier> getAllCptModifier(){
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("cptModifierId")).list();
    }

    @Override
    public CptModifier createCptModifier(CptModifier cptModifier){
      persist(cptModifier);
      return cptModifier;
    }

    @Override
    public CptModifier getCptModifierByCptModifierId(int CptModifierId){
        return (CptModifier) createCriteria().add(Restrictions.eq("cptModifierId", CptModifierId)).uniqueResult();
    }
    

    @Override
    public CptModifier updateCptModifier(CptModifier cptModifier){
      update(cptModifier);
      return cptModifier;
    }

    @Override
    public boolean deleteCptModifier(int cptModifierId){
     boolean result = true;
        CptModifier cptModifier = (CptModifier) createCriteria().add(Restrictions.eq("cptModifierId", cptModifierId)).uniqueResult();
        cptModifier.setIsDeleted(result);
        update(cptModifier);
        return result;
    }
    
}
