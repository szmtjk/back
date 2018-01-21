package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务流向
 */
@Component
public class CustomerTaskFlowConverter extends ModelConverter<CustomerTaskFlowDO, CustomerTaskFlow> {
    @Override
    public CustomerTaskFlowDO toDataObject(CustomerTaskFlow src) {
        CustomerTaskFlowDO dst = new CustomerTaskFlowDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public CustomerTaskFlow toModel(CustomerTaskFlowDO src) {
        CustomerTaskFlow dst = new CustomerTaskFlow();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
