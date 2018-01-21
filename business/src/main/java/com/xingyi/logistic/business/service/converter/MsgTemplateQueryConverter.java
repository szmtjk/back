package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.MsgTemplateDBQuery;
import com.xingyi.logistic.business.model.MsgTemplateQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 危险区域
 */
@Component
public class MsgTemplateQueryConverter extends QueryConditionConverter<MsgTemplateQuery, MsgTemplateDBQuery> {

    @Override
    public MsgTemplateDBQuery toDOCondition(MsgTemplateQuery src) {
        MsgTemplateDBQuery dst = new MsgTemplateDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
