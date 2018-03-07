package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipEventDBQuery;
import com.xingyi.logistic.business.model.ShipEventQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class ShipEventQueryConverter extends QueryConditionConverter<ShipEventQuery, ShipEventDBQuery> {

    @Override
    public ShipEventDBQuery toDOCondition(ShipEventQuery src) {
        ShipEventDBQuery dst = new ShipEventDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
