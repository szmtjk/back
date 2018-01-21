package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TerminalMsgDBQuery;
import com.xingyi.logistic.business.model.TerminalMsgQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TerminalMsgQueryConverter extends QueryConditionConverter<TerminalMsgQuery,TerminalMsgDBQuery> {

    @Override
    public TerminalMsgDBQuery toDOCondition(TerminalMsgQuery src) {
        TerminalMsgDBQuery tmd = new TerminalMsgDBQuery();
        if (src != null) {
            paginationConvert(src, tmd);
            BeanUtils.copyProperties(src, tmd);
        }
        return tmd;
    }
}
