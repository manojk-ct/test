/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.CptCharge;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ICptChargeRepository {
    public List<CptCharge> getAllCptCharge();

    public CptCharge createCptCharge(CptCharge cptCharge);

    public CptCharge getCptChargeByCptChargeId(int CptChargeId);

    public CptCharge updateCptCharge(CptCharge cptCharge);

    public boolean deleteCptCharge(int cptChargeId);
}
