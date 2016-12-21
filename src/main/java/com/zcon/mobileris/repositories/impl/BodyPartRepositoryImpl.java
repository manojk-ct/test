package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.BodyPart;
import com.zcon.mobileris.entity.Modality;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IBodyPartRepository;

/**
 * @author ManojK
 */
@Repository("bodyPartRepository")
public class BodyPartRepositoryImpl extends AbstractRepository<Integer, BodyPart> implements IBodyPartRepository{

    @Override
    public List<BodyPart> getAllBodyParts() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("bodyPartName")).list();
    }

    @Override
    public BodyPart createBodyPart(BodyPart bodyPart) {      
       Set<Modality> modality = new HashSet<>();
       for(Modality m : bodyPart.getModality())
       {
           modality.add((Modality)getSession().get(Modality.class,m.getModalityId()));
       }       
       bodyPart.setModality(modality);
       persist(bodyPart);
       return bodyPart;
    }

    @Override
    public BodyPart getBodyPartById(int bodyPartId) {
        return (BodyPart) createCriteria().add(Restrictions.eq("bodyPartId", bodyPartId)).uniqueResult();
    }

    @Override
    public BodyPart updateBodyPart(int bodyPartId, BodyPart bodyPart) {
        
       Set<Modality> modality = new HashSet<>();
       for(Modality m : bodyPart.getModality())
       {
           modality.add((Modality)getSession().get(Modality.class,m.getModalityId()));
       }       
       bodyPart.setModality(modality);       
        
       update(bodyPart);
       return bodyPart;
    }

    @Override
    public BodyPart deleteBodyPartById(int bodyPartId) {
        BodyPart bodyPart = (BodyPart) createCriteria().add(Restrictions.eq("bodyPartId", bodyPartId)).uniqueResult();
        bodyPart.setIsDeleted(true);
        update(bodyPart);
        return bodyPart;
    }
   
}
