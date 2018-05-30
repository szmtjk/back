package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShippingPlanDBQuery;
import com.xingyi.logistic.business.model.ShippingPlanQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class ShippingPlanQueryConverter extends QueryConditionConverter<ShippingPlanQuery, ShippingPlanDBQuery> {

    @Override
    public ShippingPlanDBQuery toDOCondition(ShippingPlanQuery src) {
        ShippingPlanDBQuery dst = new ShippingPlanDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
