/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.IcdCode;
import java.util.List;

/**
 *
 * @author MayuriM
 */
public interface IIcdRepository {
    
    public List<IcdCode> findAllIcdCodes();

    public IcdCode createIcd(IcdCode icdCode);

    public IcdCode findIcdCodeByIcdCodeId(int icdId);

    public IcdCode updateIcdCode(IcdCode icdCode);

    public boolean deleteIcdCode(int icdId);
}