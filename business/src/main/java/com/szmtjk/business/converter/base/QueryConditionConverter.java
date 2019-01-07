package com.szmtjk.business.converter.base;

import com.szmtjk.business.bean.base.BaseDBQueryPage;
import com.szmtjk.business.bean.base.BaseQueryPage;

public abstract class QueryConditionConverter <S extends BaseQueryPage, T extends BaseDBQueryPage> {

    public abstract T toDOCondition(S s);

    protected void paginationConvert(S src, T target) {
        int page = src.getPage() != null ? src.getPage() : 1;
        if (page <= 0) {
            page = 1;
        }
        int pageSize = src.getPageSize() != null ? src.getPageSize() : 10;
        if (pageSize <= 0) {
            pageSize = 10;
        }
        target.setLimitNum(pageSize);
        target.setStartRow((page - 1) * pageSize);
    }
}