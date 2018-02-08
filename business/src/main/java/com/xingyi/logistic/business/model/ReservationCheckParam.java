package com.xingyi.logistic.business.model;

import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Jadic on 2018/1/21.
 */
public class ReservationCheckParam {

    @NotNull
    private Integer leftDispatchId;
    @NotNullEmpty
    private String plans;

    private List<ReservationCheckFlagInfo> planList;

    public Integer getLeftDispatchId() {
        return leftDispatchId;
    }

    public void setLeftDispatchId(Integer leftDispatchId) {
        this.leftDispatchId = leftDispatchId;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    public List<ReservationCheckFlagInfo> getPlanList() {
        return planList;
    }

    public void setPlanList(List<ReservationCheckFlagInfo> planList) {
        this.planList = planList;
    }
}
