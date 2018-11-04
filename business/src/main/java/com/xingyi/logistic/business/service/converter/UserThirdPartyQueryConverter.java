package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.UserThirdPartyDBQuery;
import com.xingyi.logistic.business.model.UserThirdPartyQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserThirdPartyQueryConverter extends QueryConditionConverter<UserThirdPartyQuery, UserThirdPartyDBQuery>{

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
