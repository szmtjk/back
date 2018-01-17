package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDO;
import com.xingyi.logistic.business.model.ShipCurrentGps;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by WCL on 2018/1/12.
 */
@Component
public class ShipCurrentGpsConverter  extends ModelConverter<ShipCurrentGpsDO, ShipCurrentGps> {
    @Override
    public ShipCurrentGpsDO toDataObject(ShipCurrentGps src) {
        ShipCurrentGpsDO dst = new ShipCurrentGpsDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ShipCurrentGps toModel(ShipCurrentGpsDO src) {
        ShipCurrentGps dst = new ShipCurrentGps();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
