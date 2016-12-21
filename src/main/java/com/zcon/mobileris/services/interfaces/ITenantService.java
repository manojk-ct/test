package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.Tenant;
import com.zcon.mobileris.models.dto.TenantDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ITenantService {
    public List<TenantDTO> getAllTenants();
    public TenantDTO createTenant(TenantDTO tenant);
    public TenantDTO getTenantByTenantId(int tenantId);
    public TenantDTO updateTenant(TenantDTO tenant);
    public boolean deleteTenant(int tenantId);
}
