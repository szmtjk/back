package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskFlowDAO;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
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

    public boolean updateDispatchStatus(long dispatchInfoId, int status) {
        try {
            dispatchInfoDAO.updateDispatchInfoStatus(dispatchInfoId, status);
            DispatchInfoDO dispatchInfoDO = dispatchInfoDAO.getById(dispatchInfoId);
            if (dispatchInfoDO != null) {
                customerTaskFlowDAO.updateCustomerTaskStatus4Sailing(dispatchInfoDO.getCustomerTaskFlowId());
            }
        } catch (Exception e) {
            LOG.error("update dispatch status err, dispatchInfoId:{}, taskStatus:{}", dispatchInfoId, status);
        }
        return true;
    }

}
