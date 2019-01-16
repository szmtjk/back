package com.szmtjk.business.service.converter;

import com.szmtjk.business.model.PushAppMsgQuery;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.db.entity.PushAppMsgDBQuery;
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
