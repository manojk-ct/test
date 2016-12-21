/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.repositories.interfaces.ICptRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MayuriM
 */
@Repository("cptRepository")
public class CptRepositoryImpl extends AbstractRepository<Integer, CptCode> implements ICptRepository {

    @Override
    public List<CptCode> findAllCptCodes() {
        List<CptCode> lst = createCriteria().add(Restrictions.eq("isDeleted", false)).setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE ).addOrder(Order.asc("cptCode")).list();
        return lst;
    }

    @Override
    public CptCode createCpt(CptCode cpt) {
       persist(cpt);
       return cpt;    
    }

    @Override
    public CptCode findCptCodeByCptCodeId(int cptId) {
       return (CptCode) createCriteria().add(Restrictions.eq("cptId", cptId)).uniqueResult();
    }

    @Override
    public CptCode updateCptCode(CptCode cpt) {
        update(cpt);
        return cpt;
    }

    @Override
    public boolean deleteCptCode(int cptId) {
        boolean result = true;
        CptCode cpt = (CptCode) createCriteria().add(Restrictions.eq("cptId",cptId)).uniqueResult();
        cpt.isIsDeleted();
        update(cpt);
        return result;
    }
    
}
