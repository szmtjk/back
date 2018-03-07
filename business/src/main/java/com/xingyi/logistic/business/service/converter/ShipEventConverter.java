package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipEventDO;
import com.xingyi.logistic.business.model.ShipEvent;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * wzf
 */
@Component
public class ShipEventConverter extends ModelConverter<ShipEventDO, ShipEvent> {
    @Override
    public ShipEventDO toDataObject(ShipEvent src) {
        ShipEventDO dst = new ShipEventDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ShipEvent toModel(ShipEventDO src) {
        ShipEvent dst = new ShipEvent();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
