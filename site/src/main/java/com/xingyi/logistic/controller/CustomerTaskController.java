package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTask;
import com.xingyi.logistic.business.model.CustomerTaskDetail;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerTaskService;
import com.xingyi.logistic.business.util.PrimitiveUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.common.bean.QueryType;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户任务
 */
@Biz("客户任务")
@RestController
@RequestMapping("/customerTask")
public class CustomerTaskController extends BaseCRUDController<CustomerTask, CustomerTaskQuery> {

    @Autowired
    private CustomerTaskService customerTaskService;

    @Override
    protected BaseService<CustomerTask, CustomerTaskQuery> getBaseService() {
        return customerTaskService;
    }

    /**
     * 加载合同
     *
     * @return
     */
    @RequestMapping(value = "/loadCustomer", method = RequestMethod.POST)
    public List<Combox> loadCustomer(@RequestParam Map<String, Object> map) {
        return customerTaskService.queryComboxCustomerInfo(map);
    }

    /**
     * 合同id加载客户名称
     *
     * @return
     */
    @RequestMapping(value = "/loadContractById", method = RequestMethod.GET)
    public List<Combox> loadContractById(@JsonParam CustomerTaskQuery customerTaskQuery) {

        return customerTaskService.loadContractById(customerTaskQuery);
    }

    /**
     * 合同id加载合同流向
     *
     * @return
     */
    @RequestMapping(value = "/loadContractFlowByContractId", method = RequestMethod.POST)
    public List<Combox> loadContractFlowByContractId(@JsonParam CustomerTaskQuery customerTaskQuery) {

        return customerTaskService.loadContractFlowByContractId(customerTaskQuery);
    }

    @RequestMapping(value = "/getTaskDetailList")
    public JsonRet<Object> getTaskDetailList(@JsonParam CustomerTaskQuery condition) {
        if (condition != null && condition.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
            return getTaskDetailMiniUIList(condition);
        }

        JsonRet<Integer> totalRet = customerTaskService.getTaskDetailTotal(condition.getKey());
        if (totalRet.isSuccess()) {
            Map<String, Object> params = new HashMap<>();
            if (PrimitiveUtil.getPrimitive(totalRet.getData(), 0) > 0) {
                JsonRet<List<CustomerTaskDetail>> listRet = customerTaskService.getTaskDetailList(condition);
                if (listRet.isSuccess()) {
                    params.put("total", totalRet.getData());
                    params.put("list", listRet.getData());
                    return JsonRet.getSuccessRet(params);
                } else {
                    return JsonRet.getErrRet(ErrCode.GET_ERR.getCode(), listRet.getMsg());
                }
            } else {
                params.put("total", 0);
                return JsonRet.getSuccessRet(params);
            }
        }
        return JsonRet.getErrRet(ErrCode.GET_ERR.getCode(), totalRet.getMsg());
    }

    private JsonRet<Object> getTaskDetailMiniUIList(CustomerTaskQuery condition) {
        MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
        JsonRet<Integer> totalRet = customerTaskService.getTaskDetailTotal(condition.getKey());
        if (totalRet.isSuccess()) {
            miniUIJsonRet.setTotal(totalRet.getData());
            if (PrimitiveUtil.getPrimitive(totalRet.getData(), 0) > 0) {
                JsonRet<List<CustomerTaskDetail>> listRet = customerTaskService.getTaskDetailList(condition);
                if (listRet.isSuccess()) {
                    miniUIJsonRet.setSuccess(true);
                    miniUIJsonRet.setData(listRet.getData());
                } else {
                    return JsonRet.getErrRet(ErrCode.GET_ERR.getCode(), listRet.getMsg());
                }
            }
        }
        return miniUIJsonRet;
    }

}
