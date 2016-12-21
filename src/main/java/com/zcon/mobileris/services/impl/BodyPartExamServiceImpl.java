package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.BodyPart;
import com.zcon.mobileris.entity.BodyPartExam;
import com.zcon.mobileris.entity.Modality;
import com.zcon.mobileris.models.dto.ExamDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.repositories.interfaces.IBodyPartExamRepository;
import com.zcon.mobileris.services.interfaces.IBodyPartExamService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ManojK
 */
@Service("bodyPartExamService")
@Transactional
public class BodyPartExamServiceImpl implements IBodyPartExamService,IConvertToDTO,IConvertToBO{

    @Autowired
    IBodyPartExamRepository bodyPartExamRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<ExamDTO> getAllExams() {
        List<BodyPartExam> examBOList = bodyPartExamRepository.getAllExams();
        List<ExamDTO> examDTOList = new ArrayList<>();
        for(BodyPartExam examBO:examBOList)
        {
            examDTOList.add((ExamDTO) _toDTO(examBO));
        }
        return examDTOList;
    }

    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        BodyPartExam examBO = bodyPartExamRepository.createExam((BodyPartExam)_toBO(examDTO));        
        return (ExamDTO)_toDTO(examBO);
    }

    @Override
    public ExamDTO updateExam(int bodyPartExamId, ExamDTO examDTO) {
        BodyPartExam examBO = bodyPartExamRepository.updateExam(bodyPartExamId, (BodyPartExam)_toBO(examDTO));
        return (ExamDTO)_toDTO(examBO);
    }

    @Override
    public ExamDTO getExamById(int bodyPartExamId) {
        return (ExamDTO)_toDTO(bodyPartExamRepository.getExamById(bodyPartExamId));
    }

    @Override
    public ExamDTO deleteExamById(int bodyPartExamId) {
        return (ExamDTO)_toDTO(bodyPartExamRepository.deleteExamById(bodyPartExamId));
    }

    @Override
    public Object _toDTO(Object bo) {
        BodyPartExam exam = (BodyPartExam) bo;
        
        ExamDTO examDTO = modelMapper.map(exam,ExamDTO.class);
        examDTO.setBodyPartId(exam.getBodyPart().getBodyPartId());
        examDTO.setModalityId(exam.getModality().getModalityId());
        
        return examDTO;
    }

    @Override
    public Object _toBO(Object dto) {        
        ExamDTO examDTO = (ExamDTO) dto;
        String username , username_part1 = " " ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        BodyPart bodyPart = new BodyPart();
        bodyPart.setBodyPartId(examDTO.getBodyPartId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        Modality modality = new Modality();
        modality.setModalityId(examDTO.getModalityId());
        
        BodyPartExam exam = modelMapper.map(examDTO,BodyPartExam.class);
        exam.setBodyPart(bodyPart);
        exam.setModality(modality);
        exam.setCommonComponent(abEntity);
        return exam;
    }
    
}
