package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.WaterLevelDBQuery;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 水位
 */
@Component
public class WaterLevelQueryConverter extends QueryConditionConverter<WaterLevelQuery, WaterLevelDBQuery> {

    @Override
    public WaterLevelDBQuery toDOCondition(WaterLevelQuery src) {
        WaterLevelDBQuery dst = new WaterLevelDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
