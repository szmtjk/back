package com.xingyi.logistic.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.model.OperationLog;
import com.xingyi.logistic.business.service.OperationLogService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;
//
//    @AfterReturning(value = "@within(biz) && @annotation(operation) && execution(* com.xingyi.logistic.controller.BaseCRUDController+.add(..))"
//            ,returning = "ret")
//    public void logAfterBizOperation(JoinPoint jp, Biz biz, Operation operation, Object ret) {
//        System.out.println("jp:" + JSON.toJSONString(jp.getArgs()));
//        System.out.println("biz" + biz.value());
//        System.out.println("operation" + operation.value());
//        System.out.println("ret:" + JSON.toJSONString(ret));
//        OperationLog operationLog = new OperationLog();
//        operationLog.setUserId(getCurrentUserId());
//        operationLog.setBizType(biz.value());
//        operationLog.setOperationType(operation.value());
//        operationLog.setRequestParam(JSON.toJSONString(jp.getArgs()));
//        if (ret instanceof JsonRet) {
//            JsonRet<?> jsonRet = (JsonRet<?>)ret;
//            operationLog.setResponseCode((jsonRet.getErrCode()));
//            operationLog.setResponseData(JSON.toJSONString(jsonRet.getData()));
//        } else {
//            operationLog.setResponseData(JSON.toJSONString(ret));
//        }
//        //operationLogService.add(operationLog);
//        System.out.println(JSON.toJSONString(operationLog));
//    }
//
//    @AfterReturning(value = "@annotation(operation) && execution(* com.xingyi.logistic.controller.BaseCRUDController+.add(..))"
//            ,returning = "ret")
//    public void logAfterBizOperation2(JoinPoint jp, Operation operation, Object ret) {
//        System.out.println("jp:" + JSON.toJSONString(jp.getArgs()));
//        System.out.println("operation" + operation.value());
//        System.out.println("ret:" + JSON.toJSONString(ret));
//        OperationLog operationLog = new OperationLog();
//        operationLog.setUserId(getCurrentUserId());
//        operationLog.setOperationType(operation.value());
//        operationLog.setRequestParam(JSON.toJSONString(jp.getArgs()));
//        if (ret instanceof JsonRet) {
//            JsonRet<?> jsonRet = (JsonRet<?>)ret;
//            operationLog.setResponseCode((jsonRet.getErrCode()));
//            operationLog.setResponseData(JSON.toJSONString(jsonRet.getData()));
//        } else {
//            operationLog.setResponseData(JSON.toJSONString(ret));
//        }
//        //operationLogService.add(operationLog);
//        System.out.println(JSON.toJSONString(operationLog));
//    }

    @AfterReturning(value = "@annotation(operation) && execution(* com.xingyi.logistic.controller.BaseController+.*(..))"
            ,returning = "ret")
    public void logAfterBizOperation3(JoinPoint jp, Operation operation, Object ret) {
        String bizName;
        Biz biz = AnnotationUtils.findAnnotation(jp.getTarget().getClass(), Biz.class);
        if (biz != null) {
            bizName = biz.value();
        } else {
            bizName = jp.getTarget().getClass().getTypeName();
        }
        OperationLog log = new OperationLog();
        log.setUserId(getCurrentUserId());
        log.setBizType(bizName);
        log.setOperationType(operation.value());
        log.setRequestParam(JSON.toJSONString(jp.getArgs()));
        if (ret instanceof JsonRet) {
            JsonRet<?> jsonRet = (JsonRet<?>)ret;
            log.setResponseCode((jsonRet.getErrCode()));
            log.setResponseData(JSON.toJSONString(jsonRet.getData()));
        } else {
            log.setResponseData(JSON.toJSONString(ret));
        }
        operationLogService.add(log);
    }

    private Long getCurrentUserId() {
        UserProfile profile = SessionUtil.getProfile();
        return profile != null ? profile.getId() : 0L;
    }
}
