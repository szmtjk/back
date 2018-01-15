package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractFlowDO;
import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 合同流向
 */
@Component
public class ContractFLowConverter extends ModelConverter<ContractFlowDO, ContractFlow> {
    @Override
    public ContractFlowDO toDataObject(ContractFlow src) {
        ContractFlowDO dst = new ContractFlowDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public ContractFlow toModel(ContractFlowDO src) {
        ContractFlow dst = new ContractFlow();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
