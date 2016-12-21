/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.models.dto.IcdCodeDTO;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface IIcdService {
    public List<IcdCodeDTO> findAllIcdCodes();

    public IcdCodeDTO createIcd(IcdCodeDTO icdCode);

    public IcdCodeDTO findIcdCodeByIcdCodeId(int icdId);

    public IcdCodeDTO updateIcdCode(IcdCodeDTO icdCode);

    public boolean deleteIcdCode(int icdId);
}