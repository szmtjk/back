package com.szmtjk.business.service.base;

import com.szmtjk.business.bean.base.BaseQueryPage;
import com.xxx.common.bean.JsonRet;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public interface BaseService<Model, Condition extends BaseQueryPage> {

    /**
     * 新增
     * @param model
     * @return
     */
    JsonRet<Long> add(Model model);

    /**
     * 修改
     * @param model
     * @return
     */
    JsonRet<Boolean> modify(Model model);

    /**
     * 删除
     * @param id
     * @return
     */
    JsonRet<Boolean> del(Long id);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    JsonRet<Model> getById(Long id);

    JsonRet<Integer> getTotal(Condition queryPage);

    JsonRet<List<Model>> getList(Condition queryPage);
}
