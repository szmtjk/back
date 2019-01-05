package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.UserThirdPartyDetailDO;
import com.szmtjk.business.model.UserThirdPartyDetail;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/11/2.
 */
@Component
public class UserThirdPartyDetailConverter extends ModelConverter<UserThirdPartyDetailDO, UserThirdPartyDetail> {
    @Override
    public UserThirdPartyDetailDO toDataObject(UserThirdPartyDetail src) {
        UserThirdPartyDetailDO dst = new UserThirdPartyDetailDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public UserThirdPartyDetail toModel(UserThirdPartyDetailDO src) {
        UserThirdPartyDetail dst = new UserThirdPartyDetail();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
