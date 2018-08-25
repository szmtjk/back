package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskFlowDAO;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.business.model.DispatchInfoQuery;
import com.xingyi.logistic.business.service.CustomerTaskFlowService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskFlowConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskFlowQueryConverter;
import com.xingyi.logistic.business.service.converter.DispatchInfoQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户任务流向
 */
@Service
public class CustomerTaskFlowServiceImpl extends BaseCRUDService<CustomerTaskFlowDO, CustomerTaskFlow, CustomerTaskFlowDBQuery, CustomerTaskFlowQuery> implements CustomerTaskFlowService {

    @Autowired
    private CustomerTaskFlowDAO customerTaskFlowDAO;

    @Autowired
    private DispatchInfoDAO dispatchInfoDAO;

    @Autowired
    private CustomerTaskFlowConverter customerTaskFlowConverter;

    @Autowired
    private CustomerTaskFlowQueryConverter customerTaskFlowQueryConverter;

    @Autowired
    private DispatchInfoQueryConverter dispatchInfoQueryConverter;

    @Override
    protected ModelConverter<CustomerTaskFlowDO, CustomerTaskFlow> getModelConverter() {
        return customerTaskFlowConverter;
    }

    @Override
    protected BaseDAO<CustomerTaskFlowDO, CustomerTaskFlowDBQuery> getDAO() {
        return customerTaskFlowDAO;
    }

    @Override
    protected QueryConditionConverter<CustomerTaskFlowQuery, CustomerTaskFlowDBQuery> getConditionConverter() {
        return customerTaskFlowQueryConverter;
    }

    public JsonRet<Long> queryTotalWeightInfo(Map<String, String> map) {
        JsonRet<Long> ret = new JsonRet<>();
        ret.setSuccess(true);
        ret.setSuccessData(customerTaskFlowDAO.queryTotalWeightInfo(map));
        return ret;
    }

    /**
     * 从运价管理中取（客户、合同、流向、时间）
     *
     * @param map
     * @return
     */
    public List<Combox> queryUnitPriceInfo(Map<String, String> map) {
        return customerTaskFlowDAO.queryUnitPriceInfo(map);
    }

    @Override
    protected boolean isBizModifyAllowed(JsonRet<?> ret, Long id) {
        boolean isAllowed = !isDispatchInfoExist(id);
        if (!isAllowed) {
            ret.setErrTip(ErrCode.CUSTOMER_TASK_FLOW_MODIFY_FORBIDDEN);
        }
        return isAllowed;
    }

    @Override
    protected boolean isBizDelAllowed(JsonRet<?> ret, Long id) {
        boolean isAllowed = !isDispatchInfoExist(id);
        if (!isAllowed) {
            ret.setErrTip(ErrCode.CUSTOMER_TASK_FLOW_DEL_FORBIDDEN);
        }
        return isAllowed;
    }

    /**
     * 客户任务流向下是否已存在调度单信息
     * @param customerTaskFlowId
     * @return
     */
    private boolean isDispatchInfoExist(Long customerTaskFlowId) {
        DispatchInfoQuery query = new DispatchInfoQuery();
        query.setCustomerTaskFlowId(customerTaskFlowId.intValue());
        DispatchInfoDBQuery dbQuery = dispatchInfoQueryConverter.toDOCondition(query);
        int count = dispatchInfoDAO.getCount(dbQuery);
        return count > 0;
    }
}
