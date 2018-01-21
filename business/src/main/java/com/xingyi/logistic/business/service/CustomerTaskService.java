package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.*;

import java.util.List;

/**
 * 客户任务
 */
public interface CustomerTaskService extends BaseService<CustomerTask, CustomerTaskQuery> {

    /**
     * 加载客户
     * @return
     */
    public List<Combox> queryComboxCustomerInfo();

    /**
     * 客户id加载合同
     * @return
     */
    public List<Combox> loadContractById(CustomerTaskQuery customerTaskQuery);

    /**
     * 合同id加载合同流向
     * @return
     */
    public List<Combox> loadContractFlowByContractId(CustomerTaskQuery customerTaskQuery);

}
