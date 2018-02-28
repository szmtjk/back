package com.xingyi.logistic.business.model;

import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Jadic on 2018/1/21.
 */
public class DispatchInfoParam {

    @NotNull
    private Long customerTaskFlowId;
    @NotNullEmpty
    private String plans;

    private List<DispatchFlagInfo> planList;

    public Long getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Long customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    public List<DispatchFlagInfo> getPlanList() {
        return planList;
    }

    public void setPlanList(List<DispatchFlagInfo> planList) {
        this.planList = planList;
    }
}
