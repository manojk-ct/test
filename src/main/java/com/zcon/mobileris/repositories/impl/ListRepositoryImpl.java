package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.BodyPartExam;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.entity.IcdCode;
import com.zcon.mobileris.entity.Modality;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.models.response.ListFacilties;
import com.zcon.mobileris.models.response.ListPayers;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import com.zcon.mobileris.repositories.interfaces.IListRepository;
/**
 *
 * @author ManojK
 */
@Repository("listRepository")
public class ListRepositoryImpl implements IListRepository {

    @Autowired
    SessionFactory sessionFactory;
    
    Session session;
    
    @Override
    public List<Country> getAllCountries() {
        
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(Country.class).addOrder(Order.asc("country_name")).list();
        
    }
    
    @Override
    public List<States> getAllStates(int country_id) {
        
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(States.class).add(Restrictions.eq("country_id", country_id)).addOrder(Order.asc("state_name")).list();
    }

    @Override
    public List<DispatchRegions> getAllDispatchRegions() {
        
        session = sessionFactory.getCurrentSession();
        return (List<DispatchRegions>) session.createCriteria(DispatchRegions.class).addOrder(Order.asc("dispatch_region_name")).list();
    }

    @Override
    public List<RadiologyGroup> getAllRadiologyGroups() {   
        
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(RadiologyGroup.class).add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("groupName")).list();       
        
    }
    
    @Override
    public List<Modality> getAllModalities() {   
        
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(Modality.class).add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("modalityName")).list();       
    }
    
    @Override
    public List<Facilities> getAllFacilities() {
        
       session = sessionFactory.getCurrentSession();       
       
       ProjectionList proj = Projections.projectionList();
         proj.add(Projections.property("facilityId"),"facilityId");
	 proj.add(Projections.property("facilityName"),"facilityName");	
       
       return session.createCriteria(Facilities.class).add(Restrictions.eq("isDeleted", false)).setProjection(proj).setResultTransformer(Transformers.aliasToBean(ListFacilties.class)).list();
    }

    @Override
    public List<Payer> getAllPayers() {
          session = sessionFactory.getCurrentSession();       
       
       ProjectionList proj = Projections.projectionList();
         proj.add(Projections.property("payerId"),"payerId");
	 proj.add(Projections.property("payerName"),"payerName");	
       
       return session.createCriteria(Payer.class).add(Restrictions.eq("isDeleted", false)).setProjection(proj).setResultTransformer(Transformers.aliasToBean(ListPayers.class)).list();
    }

    @Override
    public List<IcdCode> getICDBySearchString(String searchString) {
        
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(IcdCode.class).add(Restrictions.or(Restrictions.like("code", searchString, MatchMode.ANYWHERE),Restrictions.like("longDesc",searchString,MatchMode.ANYWHERE))).setMaxResults(10).list();
                
    }

    @Override
    public List<BodyPartExam> getAllExams() {
        session = sessionFactory.getCurrentSession();
        return session.createCriteria(BodyPartExam.class).add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("examName")).list();       
    }
}
