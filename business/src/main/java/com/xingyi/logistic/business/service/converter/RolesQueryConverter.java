package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.RolesDBQuery;
import com.xingyi.logistic.authentication.model.RolesQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RolesQueryConverter extends QueryConditionConverter<RolesQuery,RolesDBQuery> {
    @Override
    public RolesDBQuery toDOCondition(RolesQuery rolesQuery) {
        RolesDBQuery dst = new RolesDBQuery();
        if (rolesQuery != null) {
            paginationConvert(rolesQuery, dst);
            BeanUtils.copyProperties(rolesQuery, dst);
        }
        return dst;
    }
}
