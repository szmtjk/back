package com.xingyi.logistic.qiangdan.service.converter;

import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xingyi.logistic.qiangdan.model.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter extends ModelConverter<ReservationDO,Reservation> {
    @Override
    public ReservationDO toDataObject(Reservation reservation) {
        ReservationDO reservationDO = new ReservationDO();
        if(null != reservation){
            BeanUtils.copyProperties(reservation, reservationDO);
        }
        return reservationDO;
    }

    @Override
    public Reservation toModel(ReservationDO data) {
        Reservation reservation = new Reservation();
        if(null != data){
            BeanUtils.copyProperties(data, reservation);
        }
        return reservation;
    }
}
