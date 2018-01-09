package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.FlowDO;
import com.xingyi.logistic.business.model.Flow;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 流向信息
 */
@Component
public class FlowConverter extends ModelConverter<FlowDO, Flow> {
    @Override
    public FlowDO toDataObject(Flow src) {
        FlowDO dst = new FlowDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Flow toModel(FlowDO src) {
        Flow dst = new Flow();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
