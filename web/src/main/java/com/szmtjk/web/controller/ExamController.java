package com.szmtjk.web.controller;

import com.szmtjk.authentication.util.UserSessionUtil;
import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamQuery;
import com.szmtjk.business.model.ExamReservation;
import com.szmtjk.business.model.ExamReservationQuery;
import com.szmtjk.business.model.User;
import com.szmtjk.business.service.ExamReservationService;
import com.szmtjk.web.controller.base.BaseCRUDController;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController extends BaseCRUDController<Exam, ExamQuery> {

    @Autowired
    private ExamReservationService examReservationService;

    @Override
    @RequestMapping(value = "/getList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonRet<Object> getList(ExamQuery examQuery) {
        User user = UserSessionUtil.getCurrentUser();
        if (user == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_BIND_USER_NOT_EXIST);
        }

        // 1. 查询当前用户关联的最新预约信息
        ExamReservationQuery reservationQuery = new ExamReservationQuery();
        reservationQuery.setMobile(user.getMobile());
        reservationQuery.setOrderBy("id");
        reservationQuery.setSortType(2);
        reservationQuery.setPageSize(1);
        JsonRet<List<ExamReservation>> reservationListRet = examReservationService.getList(reservationQuery);
        if (reservationListRet.isSuccess() && !CollectionUtils.isEmpty(reservationListRet.getData())) {
            // 根据预约信息中的个人信息去查询相应的体检报告
            ExamReservation examReservation = reservationListRet.getData().get(0);
            examQuery.setMobile(examReservation.getMobile());
            examQuery.setFullName(examReservation.getName());
            examQuery.setGender(examReservation.getGender());
            return super.getList(examQuery);
        }
        return JsonRet.getErrRet(ErrCode.DATA_NOT_EXIST);
    }
}
