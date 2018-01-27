package com.xingyi.logistic.qiangdan;

import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import com.xingyi.logistic.qiangdan.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends BaseCRUDController<Reservation,ReservationQuery> {

    @Autowired
    private ReservationService reservationService;

    @Override
    protected BaseService<Reservation, ReservationQuery> getBaseService() {
        return this.reservationService;
    }
}
