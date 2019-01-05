package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.RolesDBQuery;
import com.szmtjk.authentication.model.RolesQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
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
