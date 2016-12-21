/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;
import com.zcon.mobileris.entity.CptCode;
import com.zcon.mobileris.models.dto.CptCodeDTO;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface ICptService {
    
    public List<CptCodeDTO> findAllCptCodes();

    public CptCodeDTO createCpt(CptCodeDTO cptId);

    public CptCodeDTO findCptCodeByCptCodeId(int cptId);

    public CptCodeDTO updateCptCode(CptCodeDTO cptId);

    public boolean deleteCptCode(int cptId);
    
}
