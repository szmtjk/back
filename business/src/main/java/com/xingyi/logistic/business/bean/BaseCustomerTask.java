package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.NotNullEmpty;


/**
 * 客户任务
 */
public class BaseCustomerTask extends BaseModelAndDO {

    @NotNullEmpty
    private Long customerId;//
    @NotNullEmpty
    private Long contractId;//合同id
    private String totalLoad;//总载重
    private String description;

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

    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
