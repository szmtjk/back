package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.FreightPlanDO;
import com.xingyi.logistic.business.model.FreightPlan;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class FreightPlanConverter extends ModelConverter<FreightPlanDO, FreightPlan> {
    @Override
    public FreightPlanDO toDataObject(FreightPlan src) {
        FreightPlanDO dst = new FreightPlanDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public FreightPlan toModel(FreightPlanDO src) {
        FreightPlan dst = new FreightPlan();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
