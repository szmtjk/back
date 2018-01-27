package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.model.CustomerTaskFlow4Dispatch;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/21.
 */
@Component
public class CustomerTaskFlow4DispatchConverter extends ModelConverter<CustomerTaskFlow4DispatchDO, CustomerTaskFlow4Dispatch> {

    @Override
    public CustomerTaskFlow4DispatchDO toDataObject(CustomerTaskFlow4Dispatch src) {
        CustomerTaskFlow4DispatchDO dst = new CustomerTaskFlow4DispatchDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public CustomerTaskFlow4Dispatch toModel(CustomerTaskFlow4DispatchDO src) {
        CustomerTaskFlow4Dispatch dst = new CustomerTaskFlow4Dispatch();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
