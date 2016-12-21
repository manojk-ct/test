package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.BodyPart;
import java.util.List;

/**
 * @author ManoJK
 */
public interface IBodyPartRepository {
    List<BodyPart> getAllBodyParts();
    BodyPart createBodyPart(BodyPart bodyPart);
    BodyPart getBodyPartById(int bodyPartId);
    BodyPart updateBodyPart(int bodyPartId,BodyPart bodyPart);
    BodyPart deleteBodyPartById(int bodyPartId);
}
