package com.szmtjk.business.service.converter;

import com.szmtjk.qiangdan.db.entity.AppUserDBQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.qiangdan.model.AppUserQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUserQueryConverter extends QueryConditionConverter<AppUserQuery,AppUserDBQuery> {
    @Override
    public AppUserDBQuery toDOCondition(AppUserQuery appUserQuery) {
        AppUserDBQuery dst = new AppUserDBQuery();
        if (appUserQuery != null) {
            paginationConvert(appUserQuery, dst);
            BeanUtils.copyProperties(appUserQuery, dst);
        }
        return dst;
    }
}
