package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTask;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.service.CustomerTaskService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户任务
 */
@Service
public class CustomerTaskServiceImpl extends BaseCRUDService<CustomerTaskDO, CustomerTask, CustomerTaskDBQuery, CustomerTaskQuery> implements CustomerTaskService {

    @Autowired
    private CustomerTaskDAO customerTaskDAO;

    @Autowired
    private CustomerTaskConverter customerTaskConverter;

    @Autowired
    private CustomerTaskQueryConverter customerTaskQueryConverter;

    @Override
    protected ModelConverter<CustomerTaskDO, CustomerTask> getModelConverter() {
        return customerTaskConverter;
    }

    @Override
    protected BaseDAO<CustomerTaskDO, CustomerTaskDBQuery> getDAO() {
        return customerTaskDAO;
    }

    @Override
    protected QueryConditionConverter<CustomerTaskQuery, CustomerTaskDBQuery> getConditionConverter() {
        return customerTaskQueryConverter;
    }

    /**
     * 加载客户
     * @return
     */
    public List<Combox> queryComboxCustomerInfo(Map<String, Object> map)
    {
        return customerTaskDAO.queryComboxCustomerInfo(map);
    }
    /**
     * 客户id加载合同
     * @return
     */
    public List<Combox> loadContractById(CustomerTaskQuery customerTaskQuery) {
            return customerTaskDAO.loadContractById(customerTaskQuery);
    }

    public List<Combox> loadContractFlowByContractId(CustomerTaskQuery customerTaskQuery){
        return customerTaskDAO.loadContractFlowByContractId(customerTaskQuery);
    }
}
