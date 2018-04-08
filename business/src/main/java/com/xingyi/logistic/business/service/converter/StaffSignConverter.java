package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.StaffSignDO;
import com.xingyi.logistic.business.model.StaffSign;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by wdx on 2018/1/1.
 */
@Component
public class StaffSignConverter extends ModelConverter<StaffSignDO, StaffSign> {
    @Override
    public StaffSignDO toDataObject(StaffSign src) {
        StaffSignDO dst = new StaffSignDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public StaffSign toModel(StaffSignDO src) {
        StaffSign dst = new StaffSign();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }


}
