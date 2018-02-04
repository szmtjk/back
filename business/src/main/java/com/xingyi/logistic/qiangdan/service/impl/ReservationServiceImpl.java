package com.xingyi.logistic.qiangdan.service.impl;

import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ReservationQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.qiangdan.db.dao.ReservationDAO;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import com.xingyi.logistic.qiangdan.service.ReservationService;
import com.xingyi.logistic.qiangdan.service.converter.ReservationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl extends BaseCRUDService<ReservationDO,Reservation,ReservationDBQuery,ReservationQuery> implements ReservationService{
    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private ReservationConverter reservationConverter;

    @Autowired
    private ReservationQueryConverter reservationQueryConverter;

    @Override
    protected ModelConverter<ReservationDO, Reservation> getModelConverter() {
        return this.reservationConverter;
    }

    @Override
    protected BaseDAO<ReservationDO, ReservationDBQuery> getDAO() {
        return this.reservationDAO;
    }

    @Override
    protected QueryConditionConverter<ReservationQuery, ReservationDBQuery> getConditionConverter() {
        return this.reservationQueryConverter;
    }

    public JsonRet<Object> queryMyOrderInfo(Map<String, Object> map)
    {
        MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
        AppUser mAppUser = SessionUtil.getAppUser();
        if (mAppUser == null)
        {
            miniUIJsonRet.setSuccess(false);
            miniUIJsonRet.setMsg("Token不合法");
            return  miniUIJsonRet;
        }

        map.put("userId", mAppUser.getId());
        // 查询总记录数
        Integer record = reservationDAO.queryMyOrderInfoCnt(map);
        if (record > 0)
        {
            miniUIJsonRet.setTotal(record);
            int startRow = 0;
            if (map.containsKey("pageIndex") && map.containsKey("pageSize"))
            {
                startRow = Integer.parseInt(map.get("pageIndex").toString()) *  Integer.parseInt(map.get("pageSize").toString());
                map.put("startRow", startRow);
            }
            else
            {
                map.put("pageSize", 10);
            }
            map.put("startRow", startRow);
            List<Map<String, Object>> argFlys = reservationDAO.queryMyOrderInfo(map);
            if (argFlys != null)
            {
                miniUIJsonRet.setSuccess(true);
                miniUIJsonRet.setData(argFlys);
            }
        }
        return miniUIJsonRet;
    }


    public JsonRet<Object> getAppById(AppUser mAppUser)
    {
        try {
            if (mAppUser == null || mAppUser.getId() == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            ReservationDO dataObject = reservationDAO.getAppById(mAppUser.getId());
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
