/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Provider;
import com.zcon.mobileris.models.dto.ProviderDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IProviderRepository {

    public List<Provider> getAllProvider();
    public Provider createProvider(Provider provider);
    public Provider getProviderByProviderId(int provider_id);
    public Provider updateProvider(Provider provider);
    public boolean deleteProvider(int provider_id);
}
