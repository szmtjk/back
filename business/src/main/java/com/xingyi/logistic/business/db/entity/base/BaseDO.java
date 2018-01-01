package com.xingyi.logistic.business.db.entity.base;

/**
 * Created by Jadic on 2017/12/30.
 */
public interface BaseDO {

    Long getId();
    void setId(Long id);

    String getCreator();
    void setUpdated(Long updated);

    Long getCreated();
    void setCreated(Long created);

    Long getUpdated();
    void setCreator(String creator);

}
