package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.PushAppMsgDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PushAppMsgDBQuery;
import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.PushAppMsg;
import com.xingyi.logistic.business.model.PushAppMsgQuery;
import com.xingyi.logistic.business.service.PushAppMsgService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.PushAppMsgConverter;
import com.xingyi.logistic.business.service.converter.PushAppMsgQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xingyi.logistic.qiangdan.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PushAppMsgServiceImpl extends BaseCRUDService<PushAppMsgDO,PushAppMsg,PushAppMsgDBQuery,PushAppMsgQuery> implements PushAppMsgService {

    @Autowired
    private PushAppMsgDAO pushAppMsgDAO;

    @Autowired
    private PushAppMsgConverter pushAppMsgConverter;

    @Autowired
    private PushAppMsgQueryConverter pushAppMsgQueryConverter;

    @Override
    protected ModelConverter<PushAppMsgDO, PushAppMsg> getModelConverter() {
        return pushAppMsgConverter;
    }

    @Override
    protected BaseDAO<PushAppMsgDO, PushAppMsgDBQuery> getDAO() {
        return pushAppMsgDAO;
    }

    @Override
    protected QueryConditionConverter<PushAppMsgQuery, PushAppMsgDBQuery> getConditionConverter() {
        return pushAppMsgQueryConverter;
    }

    public JsonRet<Object> getAppById(AppUser mAppUser)
    {
        try {
            if (mAppUser == null || mAppUser.getId() == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            PushAppMsgDO dataObject = pushAppMsgDAO.getAppById(mAppUser.getId());
            if (dataObject == null) {
                return JsonRet.getErrRet(ErrCode.DATA_NOT_EXIST);
            } else {
                return JsonRet.getSuccessRet(getModelConverter().toModel(dataObject));
            }
        } catch (Exception e) {
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    public JsonRet<List<PushAppMsgDO>> getListById(PushAppMsgDO pushAppMsgDO) {
        try {

            List<PushAppMsgDO> dataObject = pushAppMsgDAO.getListById(pushAppMsgDO);
            if (dataObject == null) {
                return JsonRet.getErrRet(ErrCode.DATA_NOT_EXIST);
            } else {
                return JsonRet.getSuccessRet(dataObject);
            }
        } catch (Exception e) {
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    public PushAppMsgDO getReservationInfo(Map<String, Object> map) {
        PushAppMsgDO pushAppMsgDO = pushAppMsgDAO.getReservationInfo(map);
        return pushAppMsgDO;
    }
}
