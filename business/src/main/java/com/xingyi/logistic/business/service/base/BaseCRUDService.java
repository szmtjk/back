package com.xingyi.logistic.business.service.base;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.bean.BaseDBQueryPage;
import com.xingyi.logistic.business.bean.BaseModelAndDO;
import com.xingyi.logistic.business.bean.BaseQueryPage;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.business.util.ParamValidator;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jadic on 2017/12/31.
 */
public abstract class BaseCRUDService<DO extends BaseModelAndDO, Model extends BaseModelAndDO, DBQueryPage extends BaseDBQueryPage, QueryPage extends BaseQueryPage> {

    private static final Logger LOG = LoggerFactory.getLogger(BaseCRUDService.class);

    public JsonRet<Long> add(Model model) {
        return commonAdd(model);
    }

    public JsonRet<Boolean> modify(Model model) {
        return commonModify(model);
    }

    public JsonRet<Boolean> del(Long id) {
        return commonDel(id);
    }

    public JsonRet<Model> getById(Long id) {
        return commonGetById(id);
    }

    public JsonRet<Integer> getTotal(QueryPage query) {
        return commonGetTotal(query);
    }

    public JsonRet<List<Model>> getList(QueryPage query) {
        return commonGetList(query);
    }

    public JsonRet<Long> commonAdd(Model model) {
        JsonRet<Long> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, model)) {
            return ret;
        }

        if (!isBizCheckPassed(ret, model)) {
            return ret;
        }

        UserProfile profile = getCurrentUser();
        if (profile != null) {
            model.setCreator(profile.getId());
            model.setUpdater(profile.getId());
        }
        DO dataObject = getModelConverter().toDataObject(model);
        dataObject.setId(null);//新增时去除id值
        BaseDAO<DO, DBQueryPage> dao = getDAO();
        try {
            if (dao.getExistCount(dataObject) > 0) {
                ret.setErrTip(ErrCode.DATA_REPEATED);
                return ret;
            }
            if (dao.insertSelective(dataObject) > 0) {//TODO transaction
                if (!isBizOperationAfterAddPassed(ret, model, dataObject)) {
                    ret.setErrTip(ErrCode.ADD_SUB_ERR);
                    return ret;
                }
                ret.setSuccessData(dataObject.getId());
                return ret;
            } else {
                ret.setErrTip(ErrCode.ADD_ERR);
            }
        } catch (Exception e) {
            ret.setErrTip(ErrCode.ADD_ERR);
            LOG.error("[ERROR]insert, do:{}", JsonUtil.toJson(dataObject), e);
        }
        return ret;
    }

    public JsonRet<Boolean> commonModify(Model model) {
        JsonRet<Boolean> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, model)) {
            return ret;
        }

        if (!isBizCheckPassed(ret, model)) {
            return ret;
        }

        UserProfile profile = getCurrentUser();
        if (profile != null) {
            model.setCreator(profile.getId());
            model.setUpdater(profile.getId());
        }

        DO dataObject = getModelConverter().toDataObject(model);
        if (dataObject.getId() == null) {
            ret.setErrTip(ErrCode.ID_INVALID);
            return ret;
        }

        if (!isBizDelAllowed(ret, dataObject.getId())) {
            return ret;
        }

        BaseDAO<DO, DBQueryPage> dao = getDAO();
        try {
            if (dao.getById(dataObject.getId()) == null) {
                ret.setErrTip(ErrCode.DATA_NOT_EXIST);
                return ret;
            }

            if (dao.getExistCount(dataObject) > 0) {
                ret.setErrTip(ErrCode.DATA_REPEATED);
                return ret;
            }
            if (dao.update(dataObject) > 0) {
                if (!isBizOperationAfterModifyPassed(ret, model, dataObject)) {
                    ret.setErrTip(ErrCode.ADD_SUB_ERR);
                    return ret;
                }
                ret.setSuccessData(true);
                return ret;
            } else {
                ret.setErrTip(ErrCode.MODIFY_ERR);
            }
        } catch (Exception e) {
            ret.setErrTip(ErrCode.MODIFY_ERR);
            LOG.error("[ERROR]modify, do:{}", JsonUtil.toJson(dataObject), e);
        }
        return ret;
    }

    public JsonRet<Boolean> commonDel(Long id) {
        JsonRet<Boolean> ret = new JsonRet<>();
        try {
            if (id == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            if (!isBizDelAllowed(ret, id)) {
                return ret;
            }

            if (getDAO().del(id) > 0) {
                return JsonRet.getSuccessRet(true);
            } else {
                return JsonRet.getErrRet(ErrCode.DEL_ERR);
            }
        } catch (Exception e) {
            LOG.error("[ERROR]delete, id:{}", id, e);
            return JsonRet.getErrRet(ErrCode.DEL_ERR);
        }
    }

    public JsonRet<Model> commonGetById(Long id) {
        try {
            if (id == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }
            DO dataObject = getDAO().getById(id);
            if (dataObject != null) {
                return JsonRet.getSuccessRet(getModelConverter().toModel(dataObject));
            } else {
                return JsonRet.getErrRet(ErrCode.GET_ERR);
            }
        } catch (Exception e) {
            LOG.error("[ERROR]getById, id:{}", id, e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    public JsonRet<Integer> commonGetTotal(QueryPage query) {
        JsonRet<Integer> ret = new JsonRet<>();
        if (query != null && !ParamValidator.isParamValid(ret, query)) {//查询条件为null时不作检测
            return ret;
        }
        DBQueryPage condition = getConditionConverter().toDOCondition(query);
        try {
            return JsonRet.getSuccessRet(getDAO().getCount(condition));
        } catch (Exception e) {
            LOG.error("[ERROR]get total", e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    public JsonRet<List<Model>> commonGetList(QueryPage query) {
        JsonRet<List<Model>> ret = new JsonRet<>();
        if (query != null && !ParamValidator.isParamValid(ret, query)) {//查询条件为null时不作检测
            return ret;
        }
        DBQueryPage condition = getConditionConverter().toDOCondition(query);
        try {
            List<DO> doList = getDAO().queryByPage(condition);
            return JsonRet.getSuccessRet(doList.stream().map(getModelConverter()::toModel).collect(Collectors.toList()));
        } catch (Exception e) {
            LOG.error("[ERROR]get list", e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    /**
     * 入参模型数据的一些特殊业务逻辑判断校验
     * @param ret
     * @param model
     * @return true 校验通过
     */
    protected boolean isBizCheckPassed(JsonRet<?> ret, Model model) {
        return true;
    }

    /**
     * 更新数据前的业务逻辑校验
     * @param ret
     * @param id
     * @return true:允许执行更新操作 false:禁止执行更新操作
     */
    protected boolean isBizModifyAllowed(JsonRet<?> ret, Long id) {
        return true;
    }

    /**
     * 删除数据前业务逻辑校验
     * @param ret
     * @param id
     * @return true 允许删除
     */
    protected boolean isBizDelAllowed(JsonRet<?> ret, Long id) {
        return true;
    }

    protected boolean isBizOperationAfterAddPassed(JsonRet<?> ret, Model model, DO dataObj) {
        return true;
    }

    protected boolean isBizOperationAfterModifyPassed(JsonRet<?> ret, Model model, DO dataObj) {
        return true;
    }

    protected abstract ModelConverter<DO, Model> getModelConverter();

    protected abstract BaseDAO<DO, DBQueryPage> getDAO();

    protected abstract QueryConditionConverter<QueryPage, DBQueryPage> getConditionConverter();

    protected UserProfile getCurrentUser() {
        try {
            return SessionUtil.getProfile();
        } catch (Exception e) {
            LOG.error("get current user err", e);
            return null;
        }
    }
}
