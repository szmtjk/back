package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipOilDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipOilDBQuery;
import com.xingyi.logistic.business.db.entity.ShipOilDO;
import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.business.service.ShipOilService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipOilConverter;
import com.xingyi.logistic.business.service.converter.ShipOilQueryConverter;
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
 * Created by wzf on 2018/1/1.
 */
@Service
public class ShipOilServiceImpl extends BaseCRUDService<ShipOilDO, ShipOil, ShipOilDBQuery, ShipOilQuery> implements ShipOilService {

    private static final Logger LOG = LoggerFactory.getLogger(ShipOilServiceImpl.class);

    @Autowired
    private ShipOilDAO shipOilDAO;

    @Autowired
    private ShipOilConverter shipOilConverter;

    @Autowired
    private ShipOilQueryConverter shipOilQueryConverter;

    @Override
    protected ModelConverter<ShipOilDO, ShipOil> getModelConverter() {
        return shipOilConverter;
    }

    @Override
    protected BaseDAO<ShipOilDO, ShipOilDBQuery> getDAO() {
        return shipOilDAO;
    }

    @Override
    protected QueryConditionConverter<ShipOilQuery, ShipOilDBQuery> getConditionConverter() {
        return shipOilQueryConverter;
    }


    @Override
    public JsonRet<Object> calculateRemainingOil(ShipOilQuery query) {

        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, query)) {
            return ret;
        }

        try {

            ShipOilDBQuery dbQuery = shipOilQueryConverter.toDOCondition(query);

            int count = shipOilDAO.calculateRemainingOilCount(dbQuery);

            List<Map<String, Object>> pageList = null;
            if (count > 0) {
                pageList = shipOilDAO.calculateRemainingOil(dbQuery);
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
            LOG.error("获取剩余油款失败, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }


    }
}
