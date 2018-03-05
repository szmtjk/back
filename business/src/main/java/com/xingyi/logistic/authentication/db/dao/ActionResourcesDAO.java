package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.ActionResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.ActionResourcesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao
public interface ActionResourcesDAO extends BaseDAO<ActionResourcesDO,ActionResourcesDBQuery>{
	/**
	 * 查询用户操作权限
	 * @param userId
	 * @return
	 */
	List<ActionResourcesDO> queryByUserId(Long userId);

	/**
	 * 加载权限树
	 * @return
	 */
	List<Map<String, Object >> queryTreeResourcesInfo();

	/**
	 * 修改父节点的节点类型
	 * @param map
	 * @return
     */
	int modifyParentLeft(@Param("pojo")Map<String, Object> map);

	int qureyParentByIdInfoCnt(@Param("id") Integer id);
}
