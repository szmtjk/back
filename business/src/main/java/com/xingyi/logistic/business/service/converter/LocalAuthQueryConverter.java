package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.LocalAuthDBQuery;
import com.xingyi.logistic.authentication.model.LocalAuthQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
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
