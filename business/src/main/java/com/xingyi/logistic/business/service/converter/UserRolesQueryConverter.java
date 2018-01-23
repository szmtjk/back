package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.UserRolesDBQuery;
import com.xingyi.logistic.authentication.db.entity.UserRolesDO;
import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
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
