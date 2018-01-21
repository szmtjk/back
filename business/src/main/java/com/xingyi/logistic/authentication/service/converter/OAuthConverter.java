package com.xingyi.logistic.authentication.service.converter;

import com.xingyi.logistic.authentication.db.entity.OAuthDO;
import com.xingyi.logistic.authentication.model.OAuth;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OAuthConverter extends ModelConverter<OAuthDO,OAuth> {
    @Override
    public OAuthDO toDataObject(OAuth userProfile) {
        OAuthDO oAuthDO = new OAuthDO();
        if(null != userProfile){
            BeanUtils.copyProperties(userProfile, oAuthDO);
        }
        return oAuthDO;
    }

    @Override
    public OAuth toModel(OAuthDO data) {
        OAuth oAuth = new OAuth();
        if(null != data){
            BeanUtils.copyProperties(data, oAuth);
        }
        return oAuth;
    }
}
