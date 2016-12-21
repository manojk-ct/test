/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.CptModifierDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ICptModifierService {
    public List<CptModifierDTO> getAllCptModifier();

    public CptModifierDTO createCptModifier(CptModifierDTO cptModifier);

    public CptModifierDTO getCptModifierByCptModifierId(int CptModifierId);

    public CptModifierDTO updateCptModifier(CptModifierDTO cptModifier);

    public boolean deleteCptModifier(int cptModifierId);
}
