package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.business.bean.BaseModelAndDO;
import com.xingyi.logistic.business.bean.BaseQueryPage;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.util.PrimitiveUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.common.bean.QueryType;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jadic on 2018/1/1.
 */
public abstract class BaseCRUDController<Model extends BaseModelAndDO, Condition extends BaseQueryPage> extends BaseController {

    @Operation("新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonRet<Long> add(@JsonParam Model model) {
        return getBaseService().add(model);
    }

    @Operation("修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public JsonRet<Boolean> modify(@JsonParam Model model) {
        return getBaseService().modify(model);
    }

    @Operation("删除")
    @RequestMapping(value = "/del", method = {RequestMethod.POST,RequestMethod.GET})
    public JsonRet<Boolean> del(@RequestParam Long id) {
        return getBaseService().del(id);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public JsonRet<Model> getById(@RequestParam Long id) {
        return getBaseService().getById(id);
    }

    @RequestMapping(value = "/getList", method = {RequestMethod.POST,RequestMethod.GET})
    public JsonRet<Object> getList(@JsonParam Condition condition) {
        if (condition != null && condition.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
            return getMiniUIList(condition);
        }
        BaseService<Model, Condition> service = getBaseService();
        JsonRet<Integer> totalRet = service.getTotal(condition);
        if (totalRet.isSuccess()) {
            Map<String, Object> params = new HashMap<>();
            if (PrimitiveUtil.getPrimitive(totalRet.getData(), 0) > 0) {
                JsonRet<List<Model>> listRet = service.getList(condition);
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

    private JsonRet<Object> getMiniUIList(Condition condition) {
        MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
        BaseService<Model, Condition> service = getBaseService();
        JsonRet<Integer> totalRet = service.getTotal(condition);
        if (totalRet.isSuccess()) {
            miniUIJsonRet.setTotal(totalRet.getData());
            if (PrimitiveUtil.getPrimitive(totalRet.getData(), 0) > 0) {
                JsonRet<List<Model>> listRet = service.getList(condition);
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

    protected abstract BaseService<Model, Condition> getBaseService();
}
