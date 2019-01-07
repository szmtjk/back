package com.szmtjk.business.service.base;

import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.util.SessionUtil;
import com.szmtjk.business.bean.base.BaseDBQueryPage;
import com.szmtjk.business.bean.base.BaseModelAndDO;
import com.szmtjk.business.bean.base.BaseQueryPage;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.util.ApplicationContextHolder;
import com.szmtjk.business.util.JsonUtil;
import com.szmtjk.business.util.ParamValidator;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jadic on 2017/12/31.
 */
public abstract class BaseCRUDService<DO extends BaseModelAndDO, Model extends BaseModelAndDO, DBQueryPage extends BaseDBQueryPage, QueryPage extends BaseQueryPage> {

    private static final Logger LOG = LoggerFactory.getLogger(BaseCRUDService.class);

    private BaseDAO<DO, DBQueryPage> currentDAO = null;

    private ModelConverter<DO, Model> currentModelConverter = null;

    private QueryConditionConverter<QueryPage, DBQueryPage> currentConditionConverter = null;

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
        ModelConverter<DO, Model> modelConverter = getCurrentModelConverter(ret);
        if (modelConverter == null) {
            return ret;
        }
        DO dataObject = modelConverter.toDataObject(model);
        dataObject.setId(null);//新增时去除id值
        BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
        if (dao == null) {
            return ret;
        }
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

        ModelConverter<DO, Model> modelConverter = getCurrentModelConverter(ret);
        if (modelConverter == null) {
            return ret;
        }
        DO dataObject = modelConverter.toDataObject(model);
        if (dataObject.getId() == null) {
            ret.setErrTip(ErrCode.ID_INVALID);
            return ret;
        }

        if (!isBizModifyAllowed(ret, dataObject.getId())) {
            return ret;
        }

        BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
        if (dao == null) {
            return ret;
        }
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
            BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
            if (dao == null) {
                return ret;
            }
            if (dao.del(id) > 0) {
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
        JsonRet<Model> ret = new JsonRet<>();
        try {
            if (id == null) {
                return JsonRet.getErrRet(ErrCode.ID_INVALID);
            }

            ModelConverter<DO, Model> modelConverter = getCurrentModelConverter(ret);
            if (modelConverter == null) {
                return ret;
            }
            BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
            if (dao == null) {
                return ret;
            }
            DO dataObject = dao.getById(id);
            if (dataObject != null) {
                return JsonRet.getSuccessRet(modelConverter.toModel(dataObject));
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
        QueryConditionConverter<QueryPage, DBQueryPage> conditionConverter = getCurrentConditionConverter(ret);
        if (conditionConverter == null) {
            return ret;
        }
        DBQueryPage condition = conditionConverter.toDOCondition(query);
        try {
            BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
            if (dao == null) {
                return ret;
            }
            return JsonRet.getSuccessRet(dao.getCount(condition));
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
        ModelConverter<DO, Model> modelConverter = getCurrentModelConverter(ret);
        if (modelConverter == null) {
            return ret;
        }
        QueryConditionConverter<QueryPage, DBQueryPage> conditionConverter = getCurrentConditionConverter(ret);
        if (conditionConverter == null) {
            return ret;
        }
        BaseDAO<DO, DBQueryPage> dao = getCurrentDAO(ret);
        if (dao == null) {
            return ret;
        }
        DBQueryPage condition = conditionConverter.toDOCondition(query);
        try {
            List<DO> doList = dao.queryByPage(condition);
            return JsonRet.getSuccessRet(doList.stream().map(modelConverter::toModel).collect(Collectors.toList()));
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

    protected BaseDAO<DO, DBQueryPage> getDAO() {
        try {
            Object bean = ApplicationContextHolder.getBean(getCurrentModelName(), "DAO");
            if (bean != null && bean instanceof BaseDAO) {
                BaseDAO<DO, DBQueryPage> dao = (BaseDAO<DO, DBQueryPage>)bean;
                return dao;
            }
        } catch (Exception e) {
            LOG.error("get dao err", e);
        }
        return null;
    }

    protected ModelConverter<DO, Model> getModelConverter() {
        try {
            Object bean = ApplicationContextHolder.getBean(getCurrentModelName(), "Converter");
            if (bean != null && bean instanceof ModelConverter) {
                ModelConverter<DO, Model> converter = (ModelConverter<DO, Model>)bean;
                return converter;
            }
        } catch (Exception e) {
            LOG.error("get model converter err", e);
        }
        return null;
    }

    protected QueryConditionConverter<QueryPage, DBQueryPage> getConditionConverter() {
        try {
            Object bean = ApplicationContextHolder.getBean(getCurrentModelName(), "ConditionConverter");
            if (bean != null && bean instanceof QueryConditionConverter) {
                QueryConditionConverter<QueryPage, DBQueryPage> converter = (QueryConditionConverter<QueryPage, DBQueryPage>)bean;
                return converter;
            }
        } catch (Exception e) {
            LOG.error("get condition converter err", e);
        }
        return null;
    }

    private String getCurrentModelName() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        String[] names = type.getActualTypeArguments()[1].getTypeName().split("\\.");
        return names[names.length - 1];
    }

    private BaseDAO<DO, DBQueryPage> getCurrentDAO(JsonRet<?> result) {
        if (currentDAO == null) {
            currentDAO = getDAO();
            if (currentDAO == null) {
                result.setErrTip(ErrCode.GET_DAO_ERR);
            }
        }
        return currentDAO;
    }

    private ModelConverter<DO, Model> getCurrentModelConverter(JsonRet<?> result) {
        if (currentModelConverter == null) {
            currentModelConverter = getModelConverter();
            if (currentModelConverter == null) {
                result.setErrTip(ErrCode.GET_MODEL_CONVERTER_ERR);
            }
        }
        return currentModelConverter;
    }

    private QueryConditionConverter<QueryPage, DBQueryPage> getCurrentConditionConverter(JsonRet<?> result) {
        if (currentConditionConverter == null) {
            currentConditionConverter = getConditionConverter();
            if (currentConditionConverter == null) {
                result.setErrTip(ErrCode.GET_CONDITION_CONVERTER_ERR);
            }
        }
        return currentConditionConverter;
    }

    protected UserProfile getCurrentUser() {
        try {
            return SessionUtil.getProfile();
        } catch (Exception e) {
            LOG.error("get current user err", e);
            return null;
        }
    }
}
