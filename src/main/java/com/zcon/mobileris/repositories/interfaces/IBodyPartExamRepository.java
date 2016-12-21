/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.BodyPartExam;
import java.util.List;

/**
 *
 * @author zcon
 */
public interface IBodyPartExamRepository {
    List<BodyPartExam> getAllExams();
    BodyPartExam createExam(BodyPartExam exam);
    BodyPartExam updateExam(int bodyPartExamId,BodyPartExam exam);
    BodyPartExam getExamById(int bodyPartExamId);
    BodyPartExam deleteExamById(int bodyPartExamId);
}
