package com.xingyi.logistic.authentication.service.converter;

import com.xingyi.logistic.authentication.db.entity.RoleResourcesDO;
import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleResourcesConverter extends ModelConverter<RoleResourcesDO,RoleResources> {
    @Override
    public RoleResourcesDO toDataObject(RoleResources roleResources) {
        RoleResourcesDO roleResourcesDO = new RoleResourcesDO();
        if(null != roleResources){
            BeanUtils.copyProperties(roleResources, roleResourcesDO);
        }
        return roleResourcesDO;
    }

    @Override
    public RoleResources toModel(RoleResourcesDO data) {
        RoleResources roleResources = new RoleResources();
        if(null != data){
            BeanUtils.copyProperties(data, roleResources);
        }
        return roleResources;
    }
}
