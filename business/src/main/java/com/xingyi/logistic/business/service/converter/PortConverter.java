package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class PortConverter extends ModelConverter<PortDO, Port> {
    @Override
    public PortDO toDataObject(Port src) {
        PortDO dst = new PortDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Port toModel(PortDO src) {
        Port dst = new Port();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
