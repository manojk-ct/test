package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.BodyPartExam;
import com.zcon.mobileris.models.dto.ExamDTO;
import java.util.List;

/**
 * @author ManojK
 */
public interface IBodyPartExamService {
    List<ExamDTO> getAllExams();
    ExamDTO createExam(ExamDTO examDTO);
    ExamDTO updateExam(int bodyPartExamId,ExamDTO examDTO);
    ExamDTO getExamById(int bodyPartExamId);
    ExamDTO deleteExamById(int bodyPartExamId);
}
