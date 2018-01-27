package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDBQuery;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReservationQueryConverter extends QueryConditionConverter<ReservationQuery,ReservationDBQuery> {
    @Override
    public ReservationDBQuery toDOCondition(ReservationQuery reservationQuery) {
        ReservationDBQuery dst = new ReservationDBQuery();
        if (reservationQuery != null) {
            paginationConvert(reservationQuery, dst);
            BeanUtils.copyProperties(reservationQuery, dst);
        }
        return dst;
    }
}
