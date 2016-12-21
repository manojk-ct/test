/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Van;
import java.util.List;
/**
 *
 * @author PravinP
 */
public interface IVanRepository {
    List<Van> getAllVANDetails();
    Van createVANDetails(Van vanDetails);
    Van updateVANDetailsById(int vanDetailsId,Van vanDetails);
    Van deleteVANDetailsById(int vanDetailsId);
    Van getVANDetailsById(int vanDetailsId);
}
