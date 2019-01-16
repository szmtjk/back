package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.db.dao.UserRolesDAO;
import com.szmtjk.authentication.model.UserRoles;
import com.szmtjk.authentication.service.UserRolesService;
import com.szmtjk.authentication.service.converter.UserRolesConverter;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.converter.base.ModelConverter;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.UserRolesQueryConverter;
import com.szmtjk.authentication.db.entity.UserRolesDBQuery;
import com.szmtjk.authentication.db.entity.UserRolesDO;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.model.UserRolesQuery;
import com.szmtjk.authentication.util.SessionUtil;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class UserRolesServiceImpl extends BaseCRUDService<UserRolesDO,UserRoles,UserRolesDBQuery,UserRolesQuery> implements UserRolesService {

    @Autowired
    private UserRolesDAO userRolesDAO;

    @Autowired
    private UserRolesConverter userRolesConverter;

    @Autowired
    private UserRolesQueryConverter userRolesQueryConverter;

    @Override
    protected ModelConverter<UserRolesDO, UserRoles> getModelConverter() {
        return this.userRolesConverter;
    }

    @Override
    protected BaseDAO<UserRolesDO, UserRolesDBQuery> getDAO() {
        return this.userRolesDAO;
    }

    @Override
    protected QueryConditionConverter<UserRolesQuery, UserRolesDBQuery> getConditionConverter() {
        return this.userRolesQueryConverter;
    }

    @Override
    public void deleteByUserId(Long userId){
        this.userRolesDAO.deleteByUserId(userId);
    }



    /**
     * 根据用户加载角色ID
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryRolesByUserIdInfo(Map<String, Object> map)
    {
        return userRolesDAO.queryRolesByUserIdInfo(map);
    }

    /**
     * 用户分配角色
     * @param model
     * @return
     */
    public JsonRet<Boolean> addfly(UserRoles model)
    {
        JsonRet<Boolean> ret = new JsonRet<Boolean>();
        //删除
        userRolesDAO.deleteByUserId(model.getUserId());
        if (!"".equals(model.getRoleIds()) && model.getRoleIds() != null)
        {
            String roleFly[] = model.getRoleIds().split("\\,");
            for (String roleId: roleFly)
            {
                model.setRoleId(Long.parseLong(roleId));
                super.add(model);
            }
        }

        ret.setSuccess(true);
        ret.setSuccessData(true);
        return  ret;
    }

    @Override
    public int setRoles(Long userId, List<Long> roleIds){
        int effectRows = 0;
        UserProfile signinProfile = SessionUtil.getSubject().getUser().getProfile();
        UserRoles ur = null;

        this.deleteByUserId(userId);

        if(!CollectionUtils.isEmpty(roleIds)){
            for(Long roleId:roleIds){
                ur = new UserRoles();
                ur.setCreator(signinProfile.getId());
                ur.setCreatorName(signinProfile.getRealName());
                ur.setUpdater(signinProfile.getId());
                ur.setUpdaterName(signinProfile.getRealName());
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                effectRows += this.userRolesDAO.insertSelective(this.userRolesConverter.toDataObject(ur));
            }
        }
        return effectRows;
    }
}
