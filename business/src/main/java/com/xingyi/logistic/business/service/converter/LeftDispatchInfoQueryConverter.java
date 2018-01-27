package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDBQuery;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 余量临调信息
 */
@Component
public class LeftDispatchInfoQueryConverter extends QueryConditionConverter<LeftDispatchInfoQuery,LeftDispatchInfoDBQuery>{
    @Override
    public LeftDispatchInfoDBQuery toDOCondition(LeftDispatchInfoQuery src) {
        LeftDispatchInfoDBQuery dst = new LeftDispatchInfoDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
