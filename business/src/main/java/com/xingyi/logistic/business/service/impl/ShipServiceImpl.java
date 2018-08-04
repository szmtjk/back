package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class ShipServiceImpl extends BaseCRUDService<ShipDO, Ship, ShipDBQuery, ShipQuery> implements ShipService {

    @Autowired
    private ShipDAO shipDAO;

    @Autowired
    private ShipConverter shipConverter;

    @Autowired
    private ShipQueryConverter shipQueryConverter;

    /**
     *
     * @param userId
     * @return
     */
    public JsonRet<Object> getAppById(AppUser mAppUser)
    {
        try {
            if (mAppUser == null || mAppUser.getId() == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            ShipDO dataObject = shipDAO.getAppById(mAppUser.getId());
            if (dataObject != null) {
                return JsonRet.getSuccessRet(getModelConverter().toModel(dataObject));
            } else {
                return JsonRet.getErrRet(ErrCode.GET_ERR);
            }
        } catch (Exception e) {
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    protected ModelConverter<ShipDO, Ship> getModelConverter() {
        return shipConverter;
    }

    @Override
    protected BaseDAO<ShipDO, ShipDBQuery> getDAO() {
        return shipDAO;
    }

    @Override
    protected QueryConditionConverter<ShipQuery, ShipDBQuery> getConditionConverter() {
        return shipQueryConverter;
    }

    @Override
    public JsonRet<Object> getShipInfo(UserProfile profile) {
        try {
            if (profile == null || profile.getId() == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            ShipDO dataObject = shipDAO.getShipInfo(profile.getId());
            if (dataObject != null) {
                return JsonRet.getSuccessRet(getModelConverter().toModel(dataObject));
            } else {
                return JsonRet.getErrRet(ErrCode.GET_ERR);
            }
        } catch (Exception e) {
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

}
