package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipOilDBQuery;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class ShipOilQueryConverter extends QueryConditionConverter<ShipOilQuery, ShipOilDBQuery> {

    @Override
    public ShipOilDBQuery toDOCondition(ShipOilQuery src) {
        ShipOilDBQuery dst = new ShipOilDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
