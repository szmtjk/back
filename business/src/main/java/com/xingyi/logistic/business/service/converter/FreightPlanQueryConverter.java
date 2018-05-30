package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.FreightPlanDBQuery;
import com.xingyi.logistic.business.model.FreightPlanQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class FreightPlanQueryConverter extends QueryConditionConverter<FreightPlanQuery, FreightPlanDBQuery> {

    @Override
    public FreightPlanDBQuery toDOCondition(FreightPlanQuery src) {
        FreightPlanDBQuery dst = new FreightPlanDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
