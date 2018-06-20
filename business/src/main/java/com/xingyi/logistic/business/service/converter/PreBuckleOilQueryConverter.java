package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDBQuery;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class PreBuckleOilQueryConverter extends QueryConditionConverter<PreBuckleOilQuery, PreBuckleOilDBQuery> {

    @Override
    public PreBuckleOilDBQuery toDOCondition(PreBuckleOilQuery src) {
        PreBuckleOilDBQuery dst = new PreBuckleOilDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}
