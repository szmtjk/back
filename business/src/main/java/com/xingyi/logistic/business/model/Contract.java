package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseContract;

/**
 * 合同信息
 */
public class Contract extends BaseContract {

    private String contractFlows;

    public String getContractFlows() {
        return contractFlows;
    }

    public void setContractFlows(String contractFlows) {
        this.contractFlows = contractFlows;
    }
}
