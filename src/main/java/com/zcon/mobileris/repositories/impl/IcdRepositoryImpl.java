/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.entity.IcdCode;
import com.zcon.mobileris.repositories.interfaces.IIcdRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MayuriM
 */
@Repository("icdRepository")
public class IcdRepositoryImpl extends AbstractRepository<Integer, IcdCode> implements IIcdRepository  {
    
    @Override
     public List<IcdCode> findAllIcdCodes() {
        List<IcdCode> lst = createCriteria().setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE ).addOrder(Order.asc("code")).list();
        return lst;
    }

    @Override
    public IcdCode createIcd(IcdCode icdCode) {
       persist(icdCode);
        return icdCode;    
    }

    @Override
    public IcdCode findIcdCodeByIcdCodeId(int icdId) {
      return getByKey(icdId);
    }

    @Override
    public IcdCode updateIcdCode(IcdCode icdCode) {
        update(icdCode);
        return icdCode;
    }

    @Override
    public boolean deleteIcdCode(int icdId) {
         boolean result = true;
        IcdCode icd = (IcdCode) createCriteria().add(Restrictions.eq("ICDId",icdId)).uniqueResult();
        //icd.isIsDeleted();
        delete(icd);
       // update(icd);
        return result;
        
    }

}