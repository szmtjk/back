package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PushAppMsgDBQuery;
import com.xingyi.logistic.business.model.PushAppMsgQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PushAppMsgQueryConverter extends QueryConditionConverter<PushAppMsgQuery,PushAppMsgDBQuery> {
    @Override
    public PushAppMsgDBQuery toDOCondition(PushAppMsgQuery src) {
        PushAppMsgDBQuery dst = new PushAppMsgDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
