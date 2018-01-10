package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractFlowDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 运价信息
 */
@Component
public class TransferPriceQueryConverter extends QueryConditionConverter<TransferPriceQuery, TransferPriceDBQuery> {

    @Override
    public TransferPriceDBQuery toDOCondition(TransferPriceQuery src) {
        TransferPriceDBQuery dst = new TransferPriceDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
