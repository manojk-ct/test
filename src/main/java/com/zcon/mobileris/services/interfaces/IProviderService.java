/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;
import com.zcon.mobileris.entity.Provider;
import com.zcon.mobileris.models.dto.ProviderDTO;
import java.util.List;
/**
 *
 * @author PradnyaS
 */
public interface IProviderService {
    public List<ProviderDTO> getAllProvider();
    public ProviderDTO createProvider(ProviderDTO provider);
    public ProviderDTO getProviderByProviderId(int provider_id);
    public ProviderDTO updateProvider(ProviderDTO provider);
    public boolean deleteProvider(int provider_id);
}
