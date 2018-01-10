package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipStaffDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipStaff;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class ShipStaffConverter extends ModelConverter<ShipStaffDO, ShipStaff> {
    @Override
    public ShipStaffDO toDataObject(ShipStaff src) {
        ShipStaffDO dst = new ShipStaffDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ShipStaff toModel(ShipStaffDO src) {
        ShipStaff dst = new ShipStaff();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
