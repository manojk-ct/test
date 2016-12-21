package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.Tenant;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.ITenantRepository;

/**
 *
 * @author PradnyaS
 */
@Repository("tenantRepository")
public class TenantRepositoryImpl extends AbstractRepository<Integer, Tenant> implements ITenantRepository {

    @Override
    public List<Tenant> getAllTenants() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("tenantName")).list();
    }

    @Override
    public Tenant getTenantByTenantId(int tenantId) {
       return (Tenant) createCriteria().add(Restrictions.eq("tenantId", tenantId)).uniqueResult();
    }

    @Override
    public boolean deleteTenant(int tenantId) {
        boolean result = true;
        Tenant tenant = (Tenant) createCriteria().add(Restrictions.eq("tenantId", tenantId)).uniqueResult();
        tenant.setIsDeleted(result);
        update(tenant);
        return result;

    }

    @Override
    public Tenant createTenant(Tenant tenant) {
        persist(tenant);
        return tenant;
    }

    @Override
    public Tenant updateTenant(Tenant tenant) {
        update(tenant);
        return tenant;
    }
}
