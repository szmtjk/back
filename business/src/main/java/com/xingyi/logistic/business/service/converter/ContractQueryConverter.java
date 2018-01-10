package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * C合同信息
 */
@Component
public class ContractQueryConverter extends QueryConditionConverter<ContractQuery, ContractDBQuery> {

    @Override
    public ContractDBQuery toDOCondition(ContractQuery src) {
        ContractDBQuery dst = new ContractDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
