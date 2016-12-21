/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.CptModifier;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface ICptModifierRepository {
    public List<CptModifier> getAllCptModifier();

    public CptModifier createCptModifier(CptModifier cptModifier);

    public CptModifier getCptModifierByCptModifierId(int CptModifierId);

    public CptModifier updateCptModifier(CptModifier cptModifier);

    public boolean deleteCptModifier(int cptModifierId);
}
