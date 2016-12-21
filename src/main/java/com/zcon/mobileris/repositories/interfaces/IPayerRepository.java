/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.models.dto.PayerDTO;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IPayerRepository {

    public List<Payer> getAllPayer();

    public Payer createPayer(Payer payer);

    public Payer getPayerByPayerId(int payer_id);

    public Payer updatePayer(Payer payer);

    public boolean deletePayer(int payer_id);
}
