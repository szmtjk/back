package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDBQuery;
import com.xingyi.logistic.business.model.DangerZoneSpeedQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 危险区域速度
 */
@Component
public class DangerZoneSpeedQueryConverter extends QueryConditionConverter<DangerZoneSpeedQuery, DangerZoneSpeedDBQuery> {

    @Override
    public DangerZoneSpeedDBQuery toDOCondition(DangerZoneSpeedQuery src) {
        DangerZoneSpeedDBQuery dst = new DangerZoneSpeedDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
