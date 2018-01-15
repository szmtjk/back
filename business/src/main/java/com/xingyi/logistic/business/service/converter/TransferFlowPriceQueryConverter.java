package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TransferFlowPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.model.TransferFlowPriceQuery;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 运价信息
 */
@Component
public class TransferFlowPriceQueryConverter extends QueryConditionConverter<TransferFlowPriceQuery, TransferFlowPriceDBQuery> {

    @Override
    public TransferFlowPriceDBQuery toDOCondition(TransferFlowPriceQuery src) {
        TransferFlowPriceDBQuery dst = new TransferFlowPriceDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
