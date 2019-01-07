package com.szmtjk.web.controller.base;

import com.szmtjk.business.bean.base.BaseModelAndDO;
import com.szmtjk.business.bean.base.BaseQueryPage;
import com.szmtjk.business.service.base.BaseService;
import com.szmtjk.business.util.ApplicationContextHolder;
import com.szmtjk.business.util.PrimitiveUtil;
import com.szmtjk.web.config.JsonParam;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import com.xxx.common.bean.MiniUIJsonRet;
import com.xxx.common.bean.QueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jadic on 2018/1/1.
 */
public abstract class BaseCRUDController<Model extends BaseModelAndDO, Condition extends BaseQueryPage> extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseCRUDController.class);

    private BaseService<Model, Condition> currentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonRet<Long> add(@JsonParam Model model) {
        JsonRet<Long> ret = new JsonRet<>();
        BaseService<Model, Condition> service = getCurrentService(ret);
        if (service == null) {
            return ret;
        }
        return service.add(model);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public JsonRet<Boolean> modify(@JsonParam Model model) {
        JsonRet<Boolean> ret = new JsonRet<>();
        BaseService<Model, Condition> service = getCurrentService(ret);
        if (service == null) {
            return ret;
        }
        return service.modify(model);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public JsonRet<Boolean> del(@RequestParam Long id) {
        JsonRet<Boolean> ret = new JsonRet<>();
        BaseService<Model, Condition> service = getCurrentService(ret);
        if (service == null) {
            return ret;
        }
        return service.del(id);
    }

    @RequestMapping("/getById")
    public JsonRet<Model> getById(@RequestParam Long id) {
        JsonRet<Model> ret = new JsonRet<>();
        BaseService<Model, Condition> service = getCurrentService(ret);
        if (service == null) {
            return ret;
        }
        return service.getById(id);
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

    private BaseService<Model, Condition> getCurrentService(JsonRet<?> result) {
        if (currentService == null) {
            currentService = getBaseService();
            if (currentService == null) {
                result.setErrTip(ErrCode.GET_SERVICE_ERR);
            }
        }
        return currentService;
    }

    protected BaseService<Model, Condition> getBaseService() {
        try {
            Object bean = ApplicationContextHolder.getBean(getCurrentModelName(), "ServiceImpl");
            if (bean != null && bean instanceof BaseService) {
                BaseService<Model, Condition> dao = (BaseService<Model, Condition>)bean;
                return dao;
            }
        } catch (Exception e) {
            LOG.error("get base service err", e);
        }
        return null;
    }

    private String getCurrentModelName() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        String[] names = type.getActualTypeArguments()[0].getTypeName().split("\\.");
        return names[names.length - 1];
    }
}
