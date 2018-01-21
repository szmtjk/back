package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.SailingInfoDBQuery;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 航次信息
 */
@Component
public class SailingInfoQueryConverter extends QueryConditionConverter<SailingInfoQuery, SailingInfoDBQuery> {

    @Override
    public SailingInfoDBQuery toDOCondition(SailingInfoQuery src) {
        SailingInfoDBQuery dst = new SailingInfoDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
