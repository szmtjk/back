package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.ActionResourcesDBQuery;
import com.xingyi.logistic.authentication.model.ActionResourcesQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
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
