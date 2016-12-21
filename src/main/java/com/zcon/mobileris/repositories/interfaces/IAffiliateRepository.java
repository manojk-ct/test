/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Affiliate;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface IAffiliateRepository {

    public List<Affiliate> getAllAffiliates();

    public Affiliate createAffiliate(Affiliate affiliates);

    public Affiliate getAffiliateByAffiliateId(int affialiateId);

    public Affiliate updateAffiliate(Affiliate affiliates);

    public boolean deleteAffiliate(int affialiateId);
}
