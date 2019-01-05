package com.szmtjk.authentication.db.dao;

import com.szmtjk.authentication.db.entity.UserProfileDBQuery;
import com.szmtjk.authentication.db.entity.UserProfileDO;
import com.szmtjk.business.db.dao.base.BaseDAO;
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
