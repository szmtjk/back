package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.model.CustomerTaskFlow4DispatchQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务流向
 */
@Component
public class CustomerTaskFlow4DispatchQueryConverter extends QueryConditionConverter<CustomerTaskFlow4DispatchQuery, CustomerTaskFlow4DispatchDBQuery> {

    @Override
    public CustomerTaskFlow4DispatchDBQuery toDOCondition(CustomerTaskFlow4DispatchQuery src) {
        CustomerTaskFlow4DispatchDBQuery dst = new CustomerTaskFlow4DispatchDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
