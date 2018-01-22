package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.UserProfileDBQuery;
import com.xingyi.logistic.authentication.db.entity.UserProfileDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午12:46.
 */
@Dao
public interface UserProfileDAO extends BaseDAO<UserProfileDO,UserProfileDBQuery> {
	/**
	 * 条件查询（不分页）
	 * @param pojo
	 * @return
	 */
	List<UserProfileDO> queryList(UserProfileDBQuery pojo);
}
