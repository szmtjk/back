package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.OAuthDBQuery;
import com.szmtjk.authentication.model.OAuthQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OAuthQueryConverter extends QueryConditionConverter<OAuthQuery,OAuthDBQuery> {
    @Override
    public OAuthDBQuery toDOCondition(OAuthQuery oAuthQuery) {
        OAuthDBQuery dst = new OAuthDBQuery();
        if (oAuthQuery != null) {
            paginationConvert(oAuthQuery, dst);
            BeanUtils.copyProperties(oAuthQuery, dst);
        }
        return dst;
    }
}
