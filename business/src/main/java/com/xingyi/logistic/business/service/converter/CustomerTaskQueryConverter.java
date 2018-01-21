package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务
 */
@Component
public class CustomerTaskQueryConverter extends QueryConditionConverter<CustomerTaskQuery, CustomerTaskDBQuery> {

    @Override
    public CustomerTaskDBQuery toDOCondition(CustomerTaskQuery src) {
        CustomerTaskDBQuery dst = new CustomerTaskDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
