/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Van;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IVanRepository;

/**
 *
 * @author PravinP
 */
@Repository("vanRepository")
public class VanRepositoryImpl extends AbstractRepository<Integer, Van> implements IVanRepository{
    
    @Override
    public List<Van> getAllVANDetails(){
        return createCriteria().add(Restrictions.eq("isDeleted",false)).list();
    }
    
    @Override
    public Van createVANDetails(Van vanDetails){
        persist(vanDetails);
        return vanDetails;
    }
    
    @Override
    public Van updateVANDetailsById(int vanDetailsId,Van vanDetails){
        update(vanDetails);
        return vanDetails;
    }
    
    @Override
    public Van deleteVANDetailsById(int vanDetailsId){
        Van vanDetails = (Van) createCriteria().add(Restrictions.eq("vanDetailId", vanDetailsId)).uniqueResult();
        vanDetails.setIsDeleted(true);
        update(vanDetails);
        return vanDetails;
    }
    
    @Override
    public Van getVANDetailsById(int vanDetailsId){
        return (Van) createCriteria().add(Restrictions.eq("isDeleted",false)).add(Restrictions.eq("vanDetailId", vanDetailsId)).uniqueResult();
    }    
}
