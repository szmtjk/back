package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.UserThirdPartyDetailDBQuery;
import com.xingyi.logistic.business.model.UserThirdPartyDetailQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserThirdPartyDetailQueryConverter extends QueryConditionConverter<UserThirdPartyDetailQuery, UserThirdPartyDetailDBQuery>{

    @Override
    public UserThirdPartyDetailDBQuery toDOCondition(UserThirdPartyDetailQuery src) {
        UserThirdPartyDetailDBQuery dst = new UserThirdPartyDetailDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
