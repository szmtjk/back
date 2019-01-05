package com.szmtjk.business.db.dao.base;

import com.szmtjk.business.bean.BaseDBQueryPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public interface BaseDAO<DO, DBQuery extends BaseDBQueryPage> {

    int insertSelective(@Param("pojo") DO pojo);

    /**
     * 当前信息已存在的数量(对于id不为空的，需排除当前记录)
     * @param pojo
     * @return
     */
    int getExistCount(@Param("pojo") DO pojo);

    DO getById(@Param("id") long id);

    int update(@Param("pojo") DO pojo);

    int del(@Param("id") long id);

    int getCount(@Param("pojo")DBQuery pojo);

    List<DO> queryByPage(@Param("pojo")DBQuery pojo);

}
