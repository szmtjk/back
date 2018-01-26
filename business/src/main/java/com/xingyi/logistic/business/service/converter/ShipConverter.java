package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipWithStaffDO;
import com.xingyi.logistic.business.model.AvailableDispatchShip;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.util.PrimitiveUtil;
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

    public AvailableDispatchShip toDispatchShip(ShipWithStaffDO src) {
        AvailableDispatchShip dst = new AvailableDispatchShip();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
            dst.setShipId(src.getId());
            int sailingArea = PrimitiveUtil.getPrimitive(src.getSailingArea(), 0);
            if (sailingArea > 0) {
                StringBuilder areas = new StringBuilder();
                boolean isSailingAreaA = (sailingArea & 0x01) == 0x01;
                boolean isSailingAreaB = (sailingArea & 0x02) == 0x02;
                boolean isSailingAreaC = (sailingArea & 0x04) == 0x04;
                if (isSailingAreaA) {
                    dst.setPreWeight(src.getLevelAWeight());
                    areas.append("A级");
                }
                if (isSailingAreaB) {
                    if (PrimitiveUtil.getPrimitive(dst.getPreWeight()) <= 0) {
                        dst.setPreWeight(src.getLevelBWeight());
                    }
                    if (areas.length() > 0) {
                        areas.append(",");
                    }
                    areas.append("B级");
                }
                if (isSailingAreaC) {
                    if (PrimitiveUtil.getPrimitive(dst.getPreWeight()) <= 0) {
                        dst.setPreWeight(src.getLevelCWeight());
                    }
                    if (areas.length() > 0) {
                        areas.append(",");
                    }
                    areas.append("C级");
                }
                dst.setSailArea(areas.toString());
            }
        }
        return dst;
    }
}
