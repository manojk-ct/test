package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.BodyPart;
import java.util.List;

/**
 * @author Manoj
 */
public interface IBodyPartService {
    List<BodyPart> getAllBodyParts();
    BodyPart createBodyPart(BodyPart bodyPart);
    BodyPart getBodyPartById(int bodyPartId);
    BodyPart updateBodyPart(int bodyPartId,BodyPart bodyPart);
    BodyPart deleteBodyPartById(int bodyPartId);
}
