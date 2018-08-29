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
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzf on 2018/1/1.
 */
@Service
public class ShipOilServiceImpl extends BaseCRUDService<ShipOilDO, ShipOil, ShipOilDBQuery, ShipOilQuery> implements ShipOilService {

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
    public JsonRet<List<ShipOilDO>> calculateRemainingOil(ShipOilDO shipOilDO) {
        try {

            List<ShipOilDO> dataObject = shipOilDAO.calculateRemainingOil(shipOilDO);
            if (dataObject == null) {
                return JsonRet.getErrRet(ErrCode.DATA_NOT_EXIST);
            } else {
                return JsonRet.getSuccessRet(dataObject);
            }
        } catch (Exception e) {
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }
}
