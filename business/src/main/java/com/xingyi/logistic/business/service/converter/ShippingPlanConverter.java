package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShippingPlanDO;
import com.xingyi.logistic.business.model.ShippingPlan;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class ShippingPlanConverter extends ModelConverter<ShippingPlanDO, ShippingPlan> {
    @Override
    public ShippingPlanDO toDataObject(ShippingPlan src) {
        ShippingPlanDO dst = new ShippingPlanDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ShippingPlan toModel(ShippingPlanDO src) {
        ShippingPlan dst = new ShippingPlan();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
