package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Flow;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Jadic on 2018/1/22.
 */
public class TestBean {


    private String id;

    @ApiModelProperty(value = "名字")
    private String name;
    private Flow flow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
