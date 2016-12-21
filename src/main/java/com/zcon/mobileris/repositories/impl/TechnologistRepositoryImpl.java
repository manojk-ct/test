/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Technologist;
import com.zcon.mobileris.repositories.interfaces.ITechnologistRepository;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MayuriM
 */
@Repository("technologistRepository")
public class TechnologistRepositoryImpl extends AbstractRepository<Integer, Technologist> implements ITechnologistRepository {

    @Override
    public List<Technologist> getAllTechnologist() {
     return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("firstName")).list();
    }

    @Override
    public Technologist createTechnologist(Technologist technologist) {
        persist(technologist);
        return technologist;    
    }

    @Override
    public Technologist getTechnologistByTechnologistId(int technologistId) {
       return (Technologist) createCriteria().add(Restrictions.eq("technologistId", technologistId)).uniqueResult();
  }

    @Override
    public Technologist updateTechnologist(Technologist technologist) {
        update(technologist);
        return technologist;    
    }

    @Override
    public boolean deleteTechnologist(int technologistId) {
   boolean result = true;
        Technologist technologist = (Technologist) createCriteria().add(Restrictions.eq("technologistId", technologistId)).uniqueResult();
        technologist.setIsDeleted(result);
        update(technologist);
        return result;
    }
    
}
