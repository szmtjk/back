package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.LocalAuthDBQuery;
import com.szmtjk.authentication.model.LocalAuthQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocalAuthQueryConverter extends QueryConditionConverter<LocalAuthQuery,LocalAuthDBQuery> {
    @Override
    public LocalAuthDBQuery toDOCondition(LocalAuthQuery localAuthQuery) {
        LocalAuthDBQuery lad = new LocalAuthDBQuery();
        if (localAuthQuery != null) {
            paginationConvert(localAuthQuery, lad);
            BeanUtils.copyProperties(localAuthQuery, lad);
        }
        return lad;
    }
}
