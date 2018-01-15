package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;

import javax.validation.constraints.NotNull;

/**
 * 运价信息
 */
public class BaseTransferPrice extends BaseModelAndDO {
    @NotNull
    private Long customerId;//客户id
    @NotNull
    private Long contractId; // 合同id
    private Integer priceType;//运价类型

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }
}
