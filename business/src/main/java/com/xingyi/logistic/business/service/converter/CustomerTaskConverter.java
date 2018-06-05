package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDetailDO;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.model.CustomerTask;
import com.xingyi.logistic.business.model.CustomerTaskDetail;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 客户任务
 */
@Component
public class CustomerTaskConverter extends ModelConverter<CustomerTaskDO, CustomerTask> {
    @Override
    public CustomerTaskDO toDataObject(CustomerTask src) {
        CustomerTaskDO dst = new CustomerTaskDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public CustomerTask toModel(CustomerTaskDO src) {
        CustomerTask dst = new CustomerTask();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    public CustomerTaskDetail toDetailModel(CustomerTaskDetailDO src) {
        CustomerTaskDetail dst = new CustomerTaskDetail();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
