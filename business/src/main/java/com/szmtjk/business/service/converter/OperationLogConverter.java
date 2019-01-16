package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.OperationLogDO;
import com.szmtjk.business.model.OperationLog;
import com.szmtjk.business.converter.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Component
public class OperationLogConverter extends ModelConverter<OperationLogDO, OperationLog> {
    @Override
    public OperationLogDO toDataObject(OperationLog src) {
        OperationLogDO dst = new OperationLogDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public OperationLog toModel(OperationLogDO src) {
        OperationLog dst = new OperationLog();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
