package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.models.dto.VanDTO;
import java.util.List;

/**
 *
 * @author PravinP
 */
public interface IVanService {
    List<VanDTO> getAllVanDetails();
    VanDTO createVANDetails(VanDTO vanDetails);
    VanDTO updateVANDetailsById(int vanDetailId,VanDTO vanDetails);
    VanDTO deleteVANDetailsById(int vanDetailId);
    VanDTO getVANDetailsById(int vanDetailId) throws RecordNotFoundException;
    
    
}
