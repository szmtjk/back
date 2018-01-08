package com.xingyi.logistic.business.service.base;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;
import com.xingyi.logistic.business.bean.BaseQueryPage;
import com.xingyi.logistic.business.util.PrimitiveUtil;

/**
 * Created by Jadic on 2017/12/31.
 */
public abstract class QueryConditionConverter <S extends BaseQueryPage, T extends BaseDBQueryPage> {

    public abstract T toDOCondition(S s);

    protected void paginationConvert(S src, T target) {
        Integer pageNumber = src.getPage();
        if (src.getQueryParamFlag() == 1) {
            pageNumber = src.getPageIndex();
        }
        int page = PrimitiveUtil.getPrimitive(pageNumber, 1);
        int pageSize = PrimitiveUtil.getPrimitive(src.getPageSize(), 10);
        target.setLimitNum(pageSize);
        target.setStartRow((page - 1) * pageSize);
    }
}
