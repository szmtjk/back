package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PlanRefuelingDBQuery;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDBQuery;
import com.xingyi.logistic.business.model.PlanRefuelingQuery;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class PlanRefuelingQueryConverter extends QueryConditionConverter<PlanRefuelingQuery, PlanRefuelingDBQuery> {

    @Override
    public PlanRefuelingDBQuery toDOCondition(PlanRefuelingQuery src) {
        PlanRefuelingDBQuery dst = new PlanRefuelingDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
