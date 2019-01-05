package com.szmtjk.authentication.db.dao;

import com.szmtjk.authentication.db.entity.UserRolesDO;
import com.szmtjk.authentication.db.entity.UserRolesDBQuery;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao
public interface UserRolesDAO extends BaseDAO<UserRolesDO,UserRolesDBQuery> {
    /**
     * 删除指定用户的角色配置
     * @param userId
     */
    public void deleteByUserId(Long userId);

    /**
     * 根据用户加载角色ID
     * @param map
     * @return
     */
    List<Map<String, Object>> queryRolesByUserIdInfo(@Param("pojo")Map<String, Object> map);
}
