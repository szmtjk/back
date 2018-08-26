package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.OperationLogDBQuery;
import com.xingyi.logistic.business.model.OperationLogQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * C合同信息
 */
@Component
public class OperationLogQueryConverter extends QueryConditionConverter<OperationLogQuery, OperationLogDBQuery> {

    @Override
    public OperationLogDBQuery toDOCondition(OperationLogQuery src) {
        OperationLogDBQuery dst = new OperationLogDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
