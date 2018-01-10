package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class ShipQueryConverter extends QueryConditionConverter<ShipQuery, ShipDBQuery> {

    @Override
    public ShipDBQuery toDOCondition(ShipQuery src) {
        ShipDBQuery dst = new ShipDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
