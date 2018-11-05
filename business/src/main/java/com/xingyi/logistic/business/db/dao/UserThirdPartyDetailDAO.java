package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDetailDBQuery;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDetailDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xiaohu on 2018/10/28.
 */
@Dao
public interface UserThirdPartyDetailDAO extends BaseDAO<UserThirdPartyDetailDO, UserThirdPartyDetailDBQuery> {

    int delByThirdId(@Param("thirdId") String thirdId, @Param("thirdType") int thirdType);

}
