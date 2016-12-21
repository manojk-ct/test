/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Affiliate;
import com.zcon.mobileris.repositories.interfaces.IAffiliateRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MayuriM
 */
@Repository("affiliateRepository")
public class AffiliateRepositoryImpl extends AbstractRepository<Integer, Affiliate> implements IAffiliateRepository {

    @Override
    public List<Affiliate> getAllAffiliates() {
         return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("comapnyName")).list();
    }

    @Override
    public Affiliate createAffiliate(Affiliate affiliates) {
        persist(affiliates);
        return affiliates;    
    }

    @Override
    public Affiliate getAffiliateByAffiliateId(int affialiateId) {
        return (Affiliate) createCriteria().add(Restrictions.eq("affialiateId", affialiateId)).uniqueResult();
    }

    @Override
    public Affiliate updateAffiliate(Affiliate affiliates) {
        update(affiliates);
        return affiliates;    
    }

    @Override
    public boolean deleteAffiliate(int affialiateId) {
        
        boolean result = true;
        Affiliate affiliates = (Affiliate) createCriteria().add(Restrictions.eq("affialiateId", affialiateId)).uniqueResult();
        affiliates.setIsDeleted(result);
        update(affiliates);
        return result;

    }
    
}
