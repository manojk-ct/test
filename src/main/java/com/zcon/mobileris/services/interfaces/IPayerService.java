/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.models.dto.PayerDTO;
import java.util.List;
/**
 *
 * @author PradnyaS
 */
public interface IPayerService {
    public List<PayerDTO> getAllPayer();

    public PayerDTO createPayer(PayerDTO payer);

    public PayerDTO getPayerByPayerId(int payer_id);

    public PayerDTO updatePayer(PayerDTO payer);

    public boolean deletePayer(int payer_id);
}
