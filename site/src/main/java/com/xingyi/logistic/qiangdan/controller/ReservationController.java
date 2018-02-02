package com.xingyi.logistic.qiangdan.controller;

import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.controller.BaseCRUDController;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import com.xingyi.logistic.qiangdan.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends BaseCRUDController<Reservation,ReservationQuery> {

    @Autowired
    private ReservationService reservationService;

    @Override
    public JsonRet<Long> add(Reservation reservation) {
        AppUser mAppUser = SessionUtil.getAppUser();
        if (mAppUser != null)
        {
            reservation.setUserId(mAppUser.getId());
            return super.add(reservation);
        }
        else
        {
            JsonRet<Long> ret = new JsonRet<>();
            ret.setSuccess(false);
            return ret;
        }
    }

    @Override
    public JsonRet<Boolean> modify(Reservation reservation) {
        reservation.setStatus(2);
        return super.modify(reservation);
    }

    @RequestMapping("/getAppById")
    public JsonRet<Reservation> getAppById() {
        return super.getById(SessionUtil.getAppUser().getId());
    }

    @Override
    protected BaseService<Reservation, ReservationQuery> getBaseService() {
        return this.reservationService;
    }
}
