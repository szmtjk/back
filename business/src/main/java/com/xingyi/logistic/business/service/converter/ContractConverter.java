package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 合同信息
 */
@Component
public class ContractConverter extends ModelConverter<ContractDO, Contract> {
    @Override
    public ContractDO toDataObject(Contract src) {
        ContractDO dst = new ContractDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Contract toModel(ContractDO src) {
        Contract dst = new Contract();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
