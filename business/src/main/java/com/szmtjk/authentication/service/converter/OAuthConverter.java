package com.szmtjk.authentication.service.converter;

import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.authentication.db.entity.OAuthDO;
import com.szmtjk.authentication.model.OAuth;
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
