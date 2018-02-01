package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.RoleResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.RoleResourcesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao
public interface RoleResourcesDAO extends BaseDAO<RoleResourcesDO,RoleResourcesDBQuery> {
    /**
     * 删除指定角色的权限
     * @param roleId
     */
    void deleteByRoleId(Long roleId);

    /**
     * 根据角色ID来加载权限
     * @param map
     * @return
     */
    List<Map<String, Object>> queryResourceByRoleInfo(@Param("pojo")Map<String, Object> map);
}
