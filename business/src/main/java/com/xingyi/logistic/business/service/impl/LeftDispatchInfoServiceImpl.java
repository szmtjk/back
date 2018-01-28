package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.LeftDispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDO;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDO;
import com.xingyi.logistic.business.model.LeftDispatch4CheckQuery;
import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.business.service.LeftDispatchInfoService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.LeftDispatch4CheckQueryConverter;
import com.xingyi.logistic.business.service.converter.LeftDispatchInfoConverter;
import com.xingyi.logistic.business.service.converter.LeftDispatchInfoQueryConverter;
import com.xingyi.logistic.business.util.JsonUtil;
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
 * 余量临调信息
 */
@Service
public class LeftDispatchInfoServiceImpl extends BaseCRUDService<LeftDispatchInfoDO,LeftDispatchInfo,LeftDispatchInfoDBQuery,LeftDispatchInfoQuery> implements LeftDispatchInfoService{

    private static final Logger  LOG = LoggerFactory.getLogger(LeftDispatchInfoServiceImpl.class);

    @Autowired
    LeftDispatchInfoDAO leftDispatchInfoDAO;

    @Autowired
    LeftDispatchInfoConverter leftDispatchInfoConverter;

    @Autowired
    LeftDispatchInfoQueryConverter leftDispatchInfoQueryConverter;

    @Autowired
    private LeftDispatch4CheckQueryConverter leftDispatch4CheckQueryConverter;

    @Override
    public JsonRet<Object> getLeftDispatch4Check(LeftDispatch4CheckQuery query) {
        LeftDispatch4CheckDBQuery leftDispatch4CheckDBQuery = leftDispatch4CheckQueryConverter.toDOCondition(query);
        try {
            int total = leftDispatchInfoDAO.queryLeftDispatch4CheckCount(leftDispatch4CheckDBQuery);
            List<LeftDispatch4CheckDO> leftDispatch4CheckList = null;
            if (total > 0) {
                leftDispatch4CheckList = leftDispatchInfoDAO.queryLeftDispatch4CheckList(leftDispatch4CheckDBQuery);
            }
            if (query != null && query.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> ret = new MiniUIJsonRet<>();
                ret.setSuccessData(total, leftDispatch4CheckList);
                return ret;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", total);
                params.put("list", leftDispatch4CheckList);
                return JsonRet.getSuccessRet(params);
            }
        } catch (Exception e) {
            LOG.error("getLeftDispatch4Check err, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    protected ModelConverter<LeftDispatchInfoDO, LeftDispatchInfo> getModelConverter() {
        return leftDispatchInfoConverter;
    }

    @Override
    protected BaseDAO<LeftDispatchInfoDO, LeftDispatchInfoDBQuery> getDAO() {
        return leftDispatchInfoDAO;
    }

    @Override
    protected QueryConditionConverter<LeftDispatchInfoQuery, LeftDispatchInfoDBQuery> getConditionConverter() {
        return leftDispatchInfoQueryConverter;
    }
}
