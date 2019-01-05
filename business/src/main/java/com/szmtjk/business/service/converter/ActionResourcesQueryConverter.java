package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.ActionResourcesDBQuery;
import com.szmtjk.authentication.model.ActionResourcesQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ActionResourcesQueryConverter extends QueryConditionConverter<ActionResourcesQuery,ActionResourcesDBQuery> {
    @Override
    public ActionResourcesDBQuery toDOCondition(ActionResourcesQuery actionResourcesQuery) {
        ActionResourcesDBQuery dst = new ActionResourcesDBQuery();
        if (actionResourcesQuery != null) {
            paginationConvert(actionResourcesQuery, dst);
            BeanUtils.copyProperties(actionResourcesQuery, dst);
        }
        return dst;
    }
}
