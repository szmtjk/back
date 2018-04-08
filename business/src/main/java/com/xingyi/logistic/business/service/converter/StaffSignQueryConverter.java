package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.StaffSignDBQuery;
import com.xingyi.logistic.business.model.StaffSignQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class StaffSignQueryConverter extends QueryConditionConverter<StaffSignQuery, StaffSignDBQuery> {

    @Override
    public StaffSignDBQuery toDOCondition(StaffSignQuery src) {
        StaffSignDBQuery dst = new StaffSignDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
