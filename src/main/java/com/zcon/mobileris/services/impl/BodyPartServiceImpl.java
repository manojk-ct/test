/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.BodyPart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.IBodyPartRepository;
import com.zcon.mobileris.services.interfaces.IBodyPartService;

/**
 *
 * @author zcon
 */
@Service("bodyPartService")
@Transactional
public class BodyPartServiceImpl implements IBodyPartService{

    @Autowired
    IBodyPartRepository bodyPartRepository;
    
    @Override
    public List<BodyPart> getAllBodyParts() {
        return bodyPartRepository.getAllBodyParts();
    }

    @Override
    public BodyPart createBodyPart(BodyPart bodyPart) {
        return bodyPartRepository.createBodyPart(bodyPart);
    }

    @Override
    public BodyPart getBodyPartById(int bodyPartId) {
        return bodyPartRepository.getBodyPartById(bodyPartId);
    }

    @Override
    public BodyPart updateBodyPart(int bodyPartId, BodyPart bodyPart) {
        return bodyPartRepository.updateBodyPart(bodyPartId, bodyPart);
    }

    @Override
    public BodyPart deleteBodyPartById(int bodyPartId) {
        return bodyPartRepository.deleteBodyPartById(bodyPartId);
    }
    
}
