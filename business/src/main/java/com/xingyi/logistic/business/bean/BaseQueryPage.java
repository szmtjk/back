package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.bean.QueryType;

/**
 * Created by Jadic on 2017/12/30.
 */
public class BaseQueryPage {

    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer pageIndex = 0;                                  //mini ui默认页码参数从0开始
    private Integer queryParamFlag = QueryType.DEFAULT.getCode();   //不同查询列表标识 0：默认标准返回格式 1：mini ui参数格式

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getQueryParamFlag() {
        return queryParamFlag;
    }

    public void setQueryParamFlag(Integer queryParamFlag) {
        this.queryParamFlag = queryParamFlag;
    }
}
