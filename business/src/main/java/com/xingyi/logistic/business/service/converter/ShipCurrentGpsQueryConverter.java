package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDBQuery;
import com.xingyi.logistic.business.model.ShipCurrentGpsQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by WCL on 2018/1/12.
 */
@Component
public class ShipCurrentGpsQueryConverter  extends QueryConditionConverter<ShipCurrentGpsQuery, ShipCurrentGpsDBQuery> {
    @Override
    public ShipCurrentGpsDBQuery toDOCondition(ShipCurrentGpsQuery src) {
        ShipCurrentGpsDBQuery dst = new ShipCurrentGpsDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
