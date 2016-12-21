/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.CptChargeDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ICptChargeService {
    public List<CptChargeDTO> getAllCptCharge();

    public CptChargeDTO createCptCharge(CptChargeDTO cptCharge);

    public CptChargeDTO getCptChargeByCptChargeId(int CptChargeId);

    public CptChargeDTO updateCptCharge(CptChargeDTO cptCharge);

    public boolean deleteCptCharge(int cptChargeId);
}
