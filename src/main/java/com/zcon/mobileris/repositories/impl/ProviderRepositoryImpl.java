/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Provider;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IProviderRepository;

/**
 *
 * @author PradnyaS
 */
@Repository("newProviderRepository")
public class ProviderRepositoryImpl extends AbstractRepository<Integer, Provider> implements IProviderRepository{

    
    @Override
    public List<Provider> getAllProvider() {
            return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("firstName")).list();
    }

    
    @Override
    public Provider getProviderByProviderId(int provider_id) {
        return (Provider) createCriteria().add(Restrictions.eq("providerId", provider_id)).uniqueResult();
    }

    @Override
    public boolean deleteProvider(int provider_id) {
        boolean result = true;
        Provider provider = (Provider) createCriteria().add(Restrictions.eq("providerId", provider_id)).uniqueResult();
        provider.setIsDeleted(result);
        update(provider);
        return result;

    }

    @Override
    public Provider createProvider(Provider provider) {
        persist(provider);
        return provider;
    }

    @Override
    public Provider updateProvider(Provider provider) {
        update(provider);
        return provider;
    }

}
