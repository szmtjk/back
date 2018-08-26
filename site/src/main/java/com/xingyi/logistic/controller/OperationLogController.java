package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.OperationLog;
import com.xingyi.logistic.business.model.OperationLogQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Biz("操作日志")
@RestController
@RequestMapping("/operationLog")
public class OperationLogController extends BaseCRUDController<OperationLog, OperationLogQuery> {

    @Autowired
    private OperationLogService operationLogService;

    @Override
    protected BaseService<OperationLog, OperationLogQuery> getBaseService() {
        return operationLogService;
    }
}
