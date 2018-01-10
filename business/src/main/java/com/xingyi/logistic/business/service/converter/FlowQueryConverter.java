package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.FlowDBQuery;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.model.FlowQuery;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 流向信息
 */
@Component
public class FlowQueryConverter extends QueryConditionConverter<FlowQuery, FlowDBQuery> {

    @Override
    public FlowDBQuery toDOCondition(FlowQuery src) {
        FlowDBQuery dst = new FlowDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
