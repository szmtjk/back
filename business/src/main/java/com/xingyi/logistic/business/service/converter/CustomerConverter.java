package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerDO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户信息
 */
@Component
public class CustomerConverter extends ModelConverter<CustomerDO, Customer> {
    @Override
    public CustomerDO toDataObject(Customer src) {
        CustomerDO dst = new CustomerDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Customer toModel(CustomerDO src) {
        Customer dst = new Customer();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
