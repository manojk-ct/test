/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.CptCode;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface ICptRepository {
    
    public List<CptCode> findAllCptCodes();

    public CptCode createCpt(CptCode cptId);

    public CptCode findCptCodeByCptCodeId(int cptId);

    public CptCode updateCptCode(CptCode cptId);

    public boolean deleteCptCode(int cptId);
    
}
