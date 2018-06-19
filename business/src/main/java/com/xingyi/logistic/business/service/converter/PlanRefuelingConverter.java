package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PlanRefuelingDO;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDO;
import com.xingyi.logistic.business.model.PlanRefueling;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class PlanRefuelingConverter extends ModelConverter<PlanRefuelingDO, PlanRefueling> {
    @Override
    public PlanRefuelingDO toDataObject(PlanRefueling src) {
        PlanRefuelingDO dst = new PlanRefuelingDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public PlanRefueling toModel(PlanRefuelingDO src) {
        PlanRefueling dst = new PlanRefueling();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
