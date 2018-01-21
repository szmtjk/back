package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDBQuery;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务流向
 */
@Component
public class CustomerTaskFlowQueryConverter extends QueryConditionConverter<CustomerTaskFlowQuery, CustomerTaskFlowDBQuery> {

    @Override
    public CustomerTaskFlowDBQuery toDOCondition(CustomerTaskFlowQuery src) {
        CustomerTaskFlowDBQuery dst = new CustomerTaskFlowDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
