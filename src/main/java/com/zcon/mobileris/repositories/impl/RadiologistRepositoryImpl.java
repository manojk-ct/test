package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Radiologist;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IRadiologistRepository;

/**
 * @author ManojK
 */
@Repository("radiologistRepository")
public class RadiologistRepositoryImpl extends AbstractRepository<Integer, Radiologist> implements IRadiologistRepository{

    @Override
    public List<Radiologist> getAllRadiologists() {
        return createCriteria().add(Restrictions.eq("isDeleted",false)).addOrder(Order.asc("firstName")).list();
    }

    @Override
    public Radiologist createRadiologist(Radiologist radiologist) {                
        persist(radiologist);
        return radiologist;
    }

    @Override
    public Radiologist updateRadiologistById(int radiologistId,Radiologist radiologist) {        
        update(radiologist);
        return radiologist;
    }   

    @Override
    public Radiologist deleteRadiologistById(int radiologistId) {
        Radiologist radiologist = (Radiologist) createCriteria().add(Restrictions.eq("radiologistId",radiologistId)).uniqueResult();
        radiologist.setIsDeleted(true);
        update(radiologist);
        return radiologist;
    }

    @Override
    public Radiologist getRadiologistById(int radiologistId) {
        return (Radiologist) createCriteria().add(Restrictions.eq("radiologistId", radiologistId)).uniqueResult();
    }
    
}
