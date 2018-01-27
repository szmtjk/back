package com.xingyi.logistic.qiangdan.service.impl;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ReservationQueryConverter;
import com.xingyi.logistic.qiangdan.db.dao.ReservationDAO;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import com.xingyi.logistic.qiangdan.service.ReservationService;
import com.xingyi.logistic.qiangdan.service.converter.ReservationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
