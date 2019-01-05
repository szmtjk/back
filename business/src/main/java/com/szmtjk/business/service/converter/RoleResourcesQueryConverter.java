package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.RoleResourcesDBQuery;
import com.szmtjk.authentication.model.RoleResourcesQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleResourcesQueryConverter extends QueryConditionConverter<RoleResourcesQuery,RoleResourcesDBQuery> {
    @Override
    public RoleResourcesDBQuery toDOCondition(RoleResourcesQuery roleResourcesQuery) {
        RoleResourcesDBQuery dst = new RoleResourcesDBQuery();
        if (roleResourcesQuery != null) {
            paginationConvert(roleResourcesQuery, dst);
            BeanUtils.copyProperties(roleResourcesQuery, dst);
        }
        return dst;
    }
}
