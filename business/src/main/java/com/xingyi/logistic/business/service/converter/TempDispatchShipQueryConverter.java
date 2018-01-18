package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TempDispatchShipDBQuery;
import com.xingyi.logistic.business.model.TempDispatchShipQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 临调船舶
 */
@Component
public class TempDispatchShipQueryConverter extends QueryConditionConverter<TempDispatchShipQuery, TempDispatchShipDBQuery> {

    @Override
    public TempDispatchShipDBQuery toDOCondition(TempDispatchShipQuery src) {
        TempDispatchShipDBQuery dst = new TempDispatchShipDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
