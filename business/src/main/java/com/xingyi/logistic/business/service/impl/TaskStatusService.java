package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskDAO;
import com.xingyi.logistic.business.db.dao.CustomerTaskFlowDAO;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaohu on 2018/3/7.
 */
@Service
public class TaskStatusService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskStatusService.class);

    @Autowired
    private DispatchInfoDAO dispatchInfoDAO;

    @Autowired
    private CustomerTaskFlowDAO customerTaskFlowDAO;

    @Autowired
    private CustomerTaskDAO customerTaskDAO;

    public boolean updateDispatchStatus(long dispatchInfoId, int status) {
        try {
            dispatchInfoDAO.updateDispatchInfoStatus(dispatchInfoId, status);
            DispatchInfoDO dispatchInfoDO = dispatchInfoDAO.getById(dispatchInfoId);
            if (dispatchInfoDO != null) {
                CustomerTaskFlowDO customerTaskFlowDO = customerTaskFlowDAO.getById(dispatchInfoDO.getCustomerTaskFlowId());
                if (customerTaskFlowDO != null) {
                    customerTaskFlowDAO.updateCustomerTaskStatus4Sailing(dispatchInfoDO.getCustomerTaskFlowId());
                    updateCustomerTaskStatus(customerTaskFlowDO.getTaskId());
                }
            }
            return true;
        } catch (Exception e) {
            LOG.error("update dispatch status err, dispatchInfoId:{}, taskStatus:{}", dispatchInfoId, status);
        }
        return false;
    }

    public boolean updateCustomerTaskFlowTaskStatus4Dispatch(long customerTaskFlowId) {
        try {
            CustomerTaskFlowDO customerTaskFlowDO = customerTaskFlowDAO.getById(customerTaskFlowId);
            if (customerTaskFlowDO != null) {
                dispatchInfoDAO.updateCustomerTaskStatus4Dispatch(customerTaskFlowId);
                updateCustomerTaskStatus(customerTaskFlowDO.getTaskId());
            }
            return true;
        } catch (Exception e) {
            LOG.error("updateCustomerTaskFlowTaskStatus err, taskId:{}", customerTaskFlowId);
        }
        return false;
    }

    public boolean updateCustomerTaskStatus(long taskId) {
        try {
            customerTaskDAO.updateCustomerTaskStatus(taskId);
            return true;
        } catch (Exception e) {
            LOG.error("updateCustomerTaskStatus err, taskId:{}", taskId);
        }
        return false;
    }

}
