package com.xingyi.logistic.qiangdan.service.impl;

import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.alibaba.fastjson.TypeReference;
import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.model.ReservationCheckFlagInfo;
import com.xingyi.logistic.business.model.ReservationCheckParam;
import com.xingyi.logistic.business.service.DispatchInfoService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ReservationQueryConverter;
import com.xingyi.logistic.business.util.PrimitiveUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.business.util.ParamValidator;
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
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl extends BaseCRUDService<ReservationDO,Reservation,ReservationDBQuery,ReservationQuery> implements ReservationService{

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private ReservationConverter reservationConverter;

    @Autowired
    private ReservationQueryConverter reservationQueryConverter;

    @Autowired
    private DispatchInfoService dispatchInfoService;

    @Override
    public JsonRet<Boolean> check(ReservationCheckParam param) {
        JsonRet<Boolean> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        param.setPlanList(JsonUtil.toObject(param.getPlans(), new TypeReference<List<ReservationCheckFlagInfo>>() {}));

        //余调确认

        List<ReservationCheckFlagInfo> toBeCheckedList = param.getPlanList().stream().filter(o->o.getCheckStatus() == 0).collect(Collectors.toList());
        List<ReservationCheckFlagInfo> allowedList = param.getPlanList().stream().filter(o->o.getCheckStatus() == 1).collect(Collectors.toList());
        List<ReservationCheckFlagInfo> deniedList = param.getPlanList().stream().filter(o->o.getCheckStatus() == 2).collect(Collectors.toList());

        //待审核的数据
        for (ReservationCheckFlagInfo o : toBeCheckedList) {
            //如果已经是审核过的，则需从调度计划表中删除
            if (PrimitiveUtil.getPrimitive(o.getDispatchId()) > 0) {
                dispatchInfoService.del(o.getDispatchId().longValue());
            }
            o.setDispatchId(0L);
            reservationDAO.update(reservationConverter.toUpdatedReservationDO(o, 0));
        }

        //审核通过
        for (ReservationCheckFlagInfo o : allowedList) {
            JsonRet<Reservation> reservationRet = getById(o.getId());
            if (!reservationRet.isSuccess() || reservationRet.getData() == null) {
                ret.setErrTip(ErrCode.ID_INVALID);
                return ret;
            }
            DispatchInfo dispatchInfo = reservationConverter.toDispatchInfo(o, reservationRet.getData());
            long dispatchId = 0;
            if (PrimitiveUtil.getPrimitive(o.getDispatchId()) > 0) {//如果已经调度过，则更新
                dispatchId = o.getDispatchId();
                JsonRet<Boolean> modifyRet = dispatchInfoService.modify(dispatchInfo);
            } else {//未调度过则新增调度计划
                JsonRet<Long> addRet = dispatchInfoService.add(dispatchInfo);
                if (addRet.isSuccess()) {
                    dispatchId = addRet.getData().intValue();
                }
            }
            o.setDispatchId(dispatchId);
            reservationDAO.update(reservationConverter.toUpdatedReservationDO(o, 1));
        }

        //审核未通过
        for (ReservationCheckFlagInfo o : deniedList) {
            if (PrimitiveUtil.getPrimitive(o.getDispatchId()) > 0) {
                JsonRet<Boolean> delRet = dispatchInfoService.del(o.getDispatchId().longValue());
                if (!delRet.isSuccess()) {
                    ret.setErrTip(delRet.getErrCode(), delRet.getMsg());
                    return ret;
                }
            }
            reservationDAO.update(reservationConverter.toUpdatedReservationDO(o, 2));
        }
        ret.setSuccessData(true);
        return ret;
    }

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
