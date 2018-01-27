package com.xingyi.logistic.qiangdan.service.converter;

import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.qiangdan.db.entity.AppUserDO;
import com.xingyi.logistic.qiangdan.model.AppUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUserConverter extends ModelConverter<AppUserDO,AppUser> {
    @Override
    public AppUserDO toDataObject(AppUser appUser) {
        AppUserDO appUserDO = new AppUserDO();
        if(null != appUser){
            BeanUtils.copyProperties(appUser, appUserDO);
        }
        return appUserDO;
    }

    @Override
    public AppUser toModel(AppUserDO data) {
        AppUser appUser = new AppUser();
        if(null != data){
            BeanUtils.copyProperties(data, appUser);
        }
        return appUser;
    }
}
