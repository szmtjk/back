package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户信息
 */
@Component
public class CustomerQueryConverter extends QueryConditionConverter<CustomerQuery, CustomerDBQuery> {

    @Override
    public CustomerDBQuery toDOCondition(CustomerQuery src) {
        CustomerDBQuery dst = new CustomerDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
