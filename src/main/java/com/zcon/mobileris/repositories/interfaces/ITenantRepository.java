package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Tenant;
import com.zcon.mobileris.models.dto.TenantDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ITenantRepository {
    public List<Tenant> getAllTenants();
    public Tenant createTenant(Tenant tenant);
    public Tenant getTenantByTenantId(int tenantId);
    public Tenant updateTenant(Tenant tenant);
    public boolean deleteTenant(int tenantId);
}
