package com.szmtjk.authentication.service.converter;

import com.szmtjk.authentication.db.entity.LocalAuthDO;
import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocalAuthConverter extends ModelConverter<LocalAuthDO,LocalAuth> {
    @Override
    public LocalAuthDO toDataObject(LocalAuth LocalAuth) {
        LocalAuthDO localAuthDO = new LocalAuthDO();
        if(null != LocalAuth){
            BeanUtils.copyProperties(LocalAuth, localAuthDO);
        }
        return localAuthDO;
    }

    @Override
    public LocalAuth toModel(LocalAuthDO data) {
        LocalAuth localAuth = new LocalAuth();
        if(null != data){
            BeanUtils.copyProperties(data, localAuth);
        }
        return localAuth;
    }
}
