package com.xingyi.logistic.qiangdan.controller;

import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.business.model.ReservationCheckParam;
import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.controller.BaseCRUDController;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import com.xingyi.logistic.qiangdan.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends BaseCRUDController<Reservation, ReservationQuery> {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public JsonRet<Boolean> check(@JsonParam ReservationCheckParam reservationCheckParam) {
        return reservationService.check(reservationCheckParam);
    }

    @Override
    public JsonRet<Long> add(Reservation reservation) {
        AppUser mAppUser = SessionUtil.getAppUser();
        if (mAppUser != null) {
            reservation.setUserId(mAppUser.getId());
            return super.add(reservation);
        } else {
            JsonRet<Long> ret = new JsonRet<>();
            ret.setSuccess(false);
            return ret;
        }
    }

    /**
     * 取消预约
     *
     * @param Reservation
     * @return
     */
    @Override
    public JsonRet<Boolean> modify(Reservation reservation) {
        reservation.setStatus(2);
        //reservation.setUserId(SessionUtil.getAppUser().getId());
        return super.modify(reservation);
    }

    @RequestMapping(value = "/getAppById", method = RequestMethod.GET)
    public JsonRet<Object> getAppById() {
        return reservationService.getAppById(SessionUtil.getAppUser());
    }


    /**
     * 获取我的订单
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getMyOrder", method = RequestMethod.GET)
    public JsonRet<Object> getMyOrder(@RequestParam Map<String, Object> map) {
        return reservationService.queryMyOrderInfo(map);
    }


    @Override
    protected BaseService<Reservation, ReservationQuery> getBaseService() {
        return this.reservationService;
    }
}
