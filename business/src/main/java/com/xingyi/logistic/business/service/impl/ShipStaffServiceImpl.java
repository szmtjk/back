package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.ShipStaffDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipStaffDBQuery;
import com.xingyi.logistic.business.db.entity.ShipStaffDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.model.ShipStaff;
import com.xingyi.logistic.business.model.ShipStaffQuery;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.ShipStaffService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipStaffConverter;
import com.xingyi.logistic.business.service.converter.ShipStaffQueryConverter;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class ShipStaffServiceImpl extends BaseCRUDService<ShipStaffDO, ShipStaff, ShipStaffDBQuery, ShipStaffQuery> implements ShipStaffService {
    private static final Logger LOG = LoggerFactory.getLogger(BaseCRUDService.class);
    @Autowired
    private ShipStaffDAO shipStaffDAO;

    @Autowired
    private ShipStaffConverter shipStaffConverter;

    @Autowired
    private ShipStaffQueryConverter shipStaffQueryConverter;

    @Override
    protected ModelConverter<ShipStaffDO, ShipStaff> getModelConverter() {
        return shipStaffConverter;
    }

    @Override
    protected BaseDAO<ShipStaffDO, ShipStaffDBQuery> getDAO() {
        return shipStaffDAO;
    }

    @Override
    protected QueryConditionConverter<ShipStaffQuery, ShipStaffDBQuery> getConditionConverter() {
        return shipStaffQueryConverter;
    }

    @Override
    public JsonRet<Integer> judege(ShipStaff shipStaff) {
        JsonRet<Integer> ret = new JsonRet<>();
        try {
            ret.setSuccessData(shipStaffDAO.judege(shipStaff));
        }catch (Exception e) {
            ret.setErrTip(ErrCode.ADD_ERR);
            LOG.error("[ERROR]judege, do:{}", JsonUtil.toJson(shipStaff), e);
        }
        return ret;
    }
}
