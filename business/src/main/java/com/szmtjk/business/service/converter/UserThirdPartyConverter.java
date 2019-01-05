package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.UserThirdPartyDO;
import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/11/2.
 */
@Component
public class UserThirdPartyConverter extends ModelConverter<UserThirdPartyDO, UserThirdParty> {
    @Override
    public UserThirdPartyDO toDataObject(UserThirdParty src) {
        UserThirdPartyDO dst = new UserThirdPartyDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public UserThirdParty toModel(UserThirdPartyDO src) {
        UserThirdParty dst = new UserThirdParty();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
