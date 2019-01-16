package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.OperationLogDBQuery;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.model.OperationLogQuery;
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
