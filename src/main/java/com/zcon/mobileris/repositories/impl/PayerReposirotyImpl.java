/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Payer;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IPayerRepository;

/**
 *
 * @author PradnyaS
 */
@Repository("newPayerRepository")
public class PayerReposirotyImpl extends AbstractRepository<Integer, Payer> implements IPayerRepository {
    
    @Override
    public List<Payer> getAllPayer() {
       return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("payerName")).list();
    }

       @Override
    public Payer getPayerByPayerId(int payerId) {
        return (Payer) createCriteria().add(Restrictions.eq("payerId", payerId)).uniqueResult();
    }

    @Override
    public boolean deletePayer(int payer_id) {
      boolean result = true;
        Payer payer = (Payer) createCriteria().add(Restrictions.eq("payerId", payer_id)).uniqueResult();
        payer.setIsDeleted(result);
        update(payer);
        return result;
    }

    @Override
    public Payer createPayer(Payer payer) {
        persist(payer);
        return payer;
    }

    @Override
    public Payer updatePayer(Payer payer) {
        update(payer);
        return payer;
    }

}
