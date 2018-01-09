package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractFlowDBQuery;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * C合同流向
 */
@Component
public class ContractFLowQueryConverter extends QueryConditionConverter<ContractFlowQuery, ContractFlowDBQuery> {

    @Override
    public ContractFlowDBQuery toDOCondition(ContractFlowQuery src) {
        ContractFlowDBQuery dst = new ContractFlowDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
