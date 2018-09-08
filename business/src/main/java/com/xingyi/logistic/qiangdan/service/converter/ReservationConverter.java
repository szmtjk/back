package com.xingyi.logistic.qiangdan.service.converter;

import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.model.ReservationCheckFlagInfo;
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

    public DispatchInfo toDispatchInfo(ReservationCheckFlagInfo src, Reservation reservation) {
        DispatchInfo dst = new DispatchInfo();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
            dst.setDispatchType(2);
            dst.setPreArriveTime(src.getPreArrivePortTime());
            dst.setPreLoad(src.getPreActualLoad());
            dst.setPreWeight(reservation.getPreLoad());
            dst.setShipFlag(3);
            if (src.getDispatchId() != null) {
                dst.setId(src.getDispatchId().longValue());
            }
            dst.setShipId(reservation.getShipId());
        }
        return dst;
    }

    public ReservationDO toUpdatedReservationDO(ReservationCheckFlagInfo src, Integer checkStatus) {
        ReservationDO dst = new ReservationDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
            dst.setCheckStatus(checkStatus);
        }
        return dst;
    }
}
