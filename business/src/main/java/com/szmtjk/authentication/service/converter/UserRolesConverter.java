package com.szmtjk.authentication.service.converter;

import com.szmtjk.authentication.db.entity.UserRolesDO;
import com.szmtjk.authentication.model.UserRoles;
import com.szmtjk.business.converter.base.ModelConverter;
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
