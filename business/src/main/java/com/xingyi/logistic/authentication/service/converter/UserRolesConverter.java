package com.xingyi.logistic.authentication.service.converter;

import com.xingyi.logistic.authentication.db.entity.UserRolesDO;
import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserRolesConverter extends ModelConverter<UserRolesDO,UserRoles> {
    @Override
    public UserRolesDO toDataObject(UserRoles userRoles) {
        UserRolesDO userRolesDO = new UserRolesDO();
        if(null != userRoles){
            BeanUtils.copyProperties(userRoles, userRolesDO);
        }
        return userRolesDO;
    }

    @Override
    public UserRoles toModel(UserRolesDO data) {
        UserRoles userRoles = new UserRoles();
        if(null != data){
            BeanUtils.copyProperties(data, userRoles);
        }
        return userRoles;
    }
}
