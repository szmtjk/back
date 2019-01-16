package com.szmtjk.authentication.service.converter;

import com.szmtjk.authentication.db.entity.RolesDO;
import com.szmtjk.authentication.model.Roles;
import com.szmtjk.business.converter.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RolesConverter extends ModelConverter<RolesDO,Roles> {
    @Override
    public RolesDO toDataObject(Roles roles) {
        RolesDO rolesDO = new RolesDO();
        if(null != roles){
            BeanUtils.copyProperties(roles, rolesDO);
        }
        return rolesDO;
    }

    @Override
    public Roles toModel(RolesDO data) {
        Roles roles = new Roles();
        if(null != data){
            BeanUtils.copyProperties(data, roles);
        }
        return roles;
    }
}
