package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.model.DispatchInfoQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class DispatchInfoQueryConverter extends QueryConditionConverter<DispatchInfoQuery, DispatchInfoDBQuery> {

    @Override
    public DispatchInfoDBQuery toDOCondition(DispatchInfoQuery src) {
        DispatchInfoDBQuery dst = new DispatchInfoDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
