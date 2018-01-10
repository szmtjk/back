package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class ShipConverter extends ModelConverter<ShipDO, Ship> {
    @Override
    public ShipDO toDataObject(Ship src) {
        ShipDO dst = new ShipDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Ship toModel(ShipDO src) {
        Ship dst = new Ship();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
