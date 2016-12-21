/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.AffiliateDTO;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface IAffiliateService {
    
    public List<AffiliateDTO> getAllAffiliates();
    public AffiliateDTO createAffiliate(AffiliateDTO affiliates);
    public AffiliateDTO getAffiliateByAffiliateId(int affialiateId);
    public AffiliateDTO updateAffiliate(AffiliateDTO affiliates);
    public boolean deleteAffiliate(int affialiateId);
}
