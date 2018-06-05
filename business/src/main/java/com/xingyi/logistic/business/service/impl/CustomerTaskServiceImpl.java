package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDetailDO;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTask;
import com.xingyi.logistic.business.model.CustomerTaskDetail;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.service.CustomerTaskService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 客户任务
 */
@Service
public class CustomerTaskServiceImpl extends BaseCRUDService<CustomerTaskDO, CustomerTask, CustomerTaskDBQuery, CustomerTaskQuery> implements CustomerTaskService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerTaskServiceImpl.class);

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

    @Override
    public JsonRet<Integer> getTaskDetailTotal(String key) {
        try {
            return JsonRet.getSuccessRet(customerTaskDAO.getTaskDetailCount(key));
        } catch (Exception e) {
            LOG.error("[ERROR]get total", e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    public JsonRet<List<CustomerTaskDetail>> getTaskDetailList(CustomerTaskQuery customerTaskQuery) {
        CustomerTaskDBQuery condition = getConditionConverter().toDOCondition(customerTaskQuery);
        try {
            List<CustomerTaskDetailDO> doList = customerTaskDAO.getTaskDetailByPage(condition);
            return JsonRet.getSuccessRet(doList.stream().map(customerTaskConverter::toDetailModel).collect(Collectors.toList()));
        } catch (Exception e) {
            LOG.error("[ERROR]get list", e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }
}
