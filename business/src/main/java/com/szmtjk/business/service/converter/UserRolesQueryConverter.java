package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.UserRolesDBQuery;
import com.szmtjk.authentication.model.UserRolesQuery;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserRolesQueryConverter extends QueryConditionConverter<UserRolesQuery,UserRolesDBQuery> {
    @Override
    public UserRolesDBQuery toDOCondition(UserRolesQuery userRolesQuery) {
        UserRolesDBQuery dst = new UserRolesDBQuery();
        if (userRolesQuery != null) {
            paginationConvert(userRolesQuery, dst);
            BeanUtils.copyProperties(userRolesQuery, dst);
        }
        return dst;
    }
}
