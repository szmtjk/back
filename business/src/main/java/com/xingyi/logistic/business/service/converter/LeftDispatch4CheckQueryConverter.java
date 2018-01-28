package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDBQuery;
import com.xingyi.logistic.business.model.LeftDispatch4CheckQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务流向
 */
@Component
public class LeftDispatch4CheckQueryConverter extends QueryConditionConverter<LeftDispatch4CheckQuery, LeftDispatch4CheckDBQuery> {

    @Override
    public LeftDispatch4CheckDBQuery toDOCondition(LeftDispatch4CheckQuery src) {
        LeftDispatch4CheckDBQuery dst = new LeftDispatch4CheckDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
