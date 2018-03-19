package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipOilDO;
import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by wzf on 2018/1/1.
 */
@Component
public class ShipOilConverter extends ModelConverter<ShipOilDO, ShipOil> {
    @Override
    public ShipOilDO toDataObject(ShipOil src) {
        ShipOilDO dst = new ShipOilDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ShipOil toModel(ShipOilDO src) {
        ShipOil dst = new ShipOil();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }


}
