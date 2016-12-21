package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.entity.BodyPartExam;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IBodyPartExamRepository;

/**
 * @author ManojK
 */
@Repository("bodyPartExamRepository")
public class BodyPartExamRepositoryImpl extends AbstractRepository<Integer, BodyPartExam> implements IBodyPartExamRepository{
    @Override
    public List<BodyPartExam> getAllExams() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("examName")).list();
    }

    @Override
    public BodyPartExam createExam(BodyPartExam exam) {
        persist(exam);
        return exam;
    }

    @Override
    public BodyPartExam updateExam(int bodyPartExamId, BodyPartExam exam) {
        update(exam);
        return exam;
    }

    @Override
    public BodyPartExam getExamById(int bodyPartExamId) {
        return (BodyPartExam) createCriteria().add(Restrictions.eq("bodyPartExamId", bodyPartExamId)).uniqueResult();
    }

    @Override
    public BodyPartExam deleteExamById(int bodyPartExamId) {
        BodyPartExam e = (BodyPartExam) createCriteria().add(Restrictions.eq("bodyPartExamId", bodyPartExamId)).uniqueResult();
        e.setIsDeleted(true);
        update(e);
        return e;
    }
    
}
