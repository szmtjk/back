package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DangerZoneDBQuery;
import com.xingyi.logistic.business.model.DangerZoneQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 危险区域
 */
@Component
public class DangerZoneQueryConverter extends QueryConditionConverter<DangerZoneQuery, DangerZoneDBQuery> {

    @Override
    public DangerZoneDBQuery toDOCondition(DangerZoneQuery src) {
        DangerZoneDBQuery dst = new DangerZoneDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
