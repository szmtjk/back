package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.SailingInfoDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.SailingInfoDBQuery;
import com.xingyi.logistic.business.db.entity.SailingInfoDO;
import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.SailingInfoService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.SailingInfoConverter;
import com.xingyi.logistic.business.service.converter.SailingInfoQueryConverter;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.business.util.ParamValidator;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.common.bean.QueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
@Service
public class SailingInfoImpl extends BaseCRUDService<SailingInfoDO, SailingInfo, SailingInfoDBQuery, SailingInfoQuery> implements SailingInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(SailingInfoImpl.class);

    @Autowired
    private SailingInfoDAO sailingInfoDAO;

    @Autowired
    private SailingInfoConverter sailingInfoConverter;

    @Autowired
    private SailingInfoQueryConverter sailingInfoQueryConverter;

    @Autowired
    private TaskStatusService taskStatusService;

    @Override
    protected boolean isBizOperationAfterAddPassed(JsonRet<?> ret, SailingInfo sailingInfo, SailingInfoDO dataObj) {
        taskStatusService.updateDispatchStatus(sailingInfo.getOrderId(), sailingInfo.getStatus());
        return true;
    }

    @Override
    protected boolean isBizOperationAfterModifyPassed(JsonRet<?> ret, SailingInfo sailingInfo, SailingInfoDO dataObj) {
        taskStatusService.updateDispatchStatus(sailingInfo.getOrderId(), sailingInfo.getStatus());
        return true;
    }

    /**
     * 加载调度的船
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryDispatchShipInfo(Map<String, String> map)
    {
        return sailingInfoDAO.queryDispatchShipInfo(map);
    }

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryUnDealDispatchShipInfo(Map<String, String> map)
    {
        return sailingInfoDAO.queryUnDealDispatchShipInfo(map);
    }

    /**
     * 加载所有已调度的船舶任务
     * @param map
     * @return
     */
    public JsonRet<Object> getDispatchShipTaskList(SailingInfoQuery query)
    {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, query)) {
            return ret;
        }
        try {
            SailingInfoDBQuery dbQuery = sailingInfoQueryConverter.toDOCondition(query);

            int count = sailingInfoDAO.getDispatchShipTaskCount(dbQuery);

            List<Map<String, Object>> pageList = null;
            if (count > 0) {
                pageList = sailingInfoDAO.getDispatchShipTaskList(dbQuery);
            }
            if (query.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
                miniUIJsonRet.setSuccessData(count, pageList);
                return miniUIJsonRet;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", count);
                params.put("list",  pageList);
                return JsonRet.getSuccessRet(params);
            }

        } catch (Exception e) {
            LOG.error("get customer task flows err, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    /**
     * 加载所有已调度的船舶任务
     * @param map
     * @return
     */
    public JsonRet<Object> getSailingShipTaskList(SailingInfoQuery query)
    {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, query)) {
            return ret;
        }
        try {
            SailingInfoDBQuery dbQuery = sailingInfoQueryConverter.toDOCondition(query);

            int count = sailingInfoDAO.getSailingShipTaskCount(dbQuery);

            List<Map<String, Object>> pageList = null;
            if (count > 0) {
                pageList = sailingInfoDAO.getSailingShipTaskList(dbQuery);
            }
            if (query.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
                miniUIJsonRet.setSuccessData(count, pageList);
                return miniUIJsonRet;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", count);
                params.put("list",  pageList);
                return JsonRet.getSuccessRet(params);
            }

        } catch (Exception e) {
            LOG.error("get customer task flows err, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    protected ModelConverter<SailingInfoDO, SailingInfo> getModelConverter() {
        return sailingInfoConverter;
    }

    @Override
    protected BaseDAO<SailingInfoDO, SailingInfoDBQuery> getDAO() {
        return sailingInfoDAO;
    }

    @Override
    protected QueryConditionConverter<SailingInfoQuery, SailingInfoDBQuery> getConditionConverter() {
        return sailingInfoQueryConverter;
    }
    @Override
    public JsonRet<Boolean> modifyBalance(Long id) {
        JsonRet<Boolean> ret = new JsonRet<>();
        try {
            if (id == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }
            if (sailingInfoDAO.modifyBalance(id) > 0) {
                return JsonRet.getSuccessRet(true);
            } else {
                return JsonRet.getErrRet(ErrCode.MODIFY_ERR);
            }
        } catch (Exception e) {
            LOG.error("[ERROR]delete, id:{}", id, e);
            return JsonRet.getErrRet(ErrCode.MODIFY_ERR);
        }
    }
}
