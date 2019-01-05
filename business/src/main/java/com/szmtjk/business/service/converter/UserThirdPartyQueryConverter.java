package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.UserThirdPartyDBQuery;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserThirdPartyQueryConverter extends QueryConditionConverter<UserThirdPartyQuery, UserThirdPartyDBQuery> {

    @Override
    public UserThirdPartyDBQuery toDOCondition(UserThirdPartyQuery src) {
        UserThirdPartyDBQuery dst = new UserThirdPartyDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
