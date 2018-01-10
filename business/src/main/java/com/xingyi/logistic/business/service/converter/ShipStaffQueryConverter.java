package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipStaffDBQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.model.ShipStaffQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class ShipStaffQueryConverter extends QueryConditionConverter<ShipStaffQuery, ShipStaffDBQuery> {

    @Override
    public ShipStaffDBQuery toDOCondition(ShipStaffQuery src) {
        ShipStaffDBQuery dst = new ShipStaffDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
