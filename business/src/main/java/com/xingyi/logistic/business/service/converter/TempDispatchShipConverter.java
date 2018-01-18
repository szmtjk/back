package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TempDispatchShipDO;
import com.xingyi.logistic.business.model.TempDispatchShip;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 临调船舶
 */
@Component
public class TempDispatchShipConverter extends ModelConverter<TempDispatchShipDO, TempDispatchShip> {
    @Override
    public TempDispatchShipDO toDataObject(TempDispatchShip src) {
        TempDispatchShipDO dst = new TempDispatchShipDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public TempDispatchShip toModel(TempDispatchShipDO src) {
        TempDispatchShip dst = new TempDispatchShip();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
