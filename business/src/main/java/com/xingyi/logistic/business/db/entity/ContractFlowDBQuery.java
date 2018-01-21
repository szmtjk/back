package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * 合同流向
 */
public class ContractFlowDBQuery extends BaseDBQueryPage {

    private Integer contractId;

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}
