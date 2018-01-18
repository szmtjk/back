package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.MsgTemplateDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.MsgTemplateDBQuery;
import com.xingyi.logistic.business.db.entity.MsgTemplateDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.MsgTemplate;
import com.xingyi.logistic.business.model.MsgTemplateQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.MsgTemplateService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.MsgTemplateConverter;
import com.xingyi.logistic.business.service.converter.MsgTemplateQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息模板
 */
@Service
public class MsgTemplateServiceImpl extends BaseCRUDService<MsgTemplateDO, MsgTemplate, MsgTemplateDBQuery, MsgTemplateQuery> implements MsgTemplateService {

    @Autowired
    private MsgTemplateDAO msgTemplateDAO;

    @Autowired
    private MsgTemplateConverter msgTemplateConverter;

    @Autowired
    private MsgTemplateQueryConverter msgTemplateQueryConverter;

    @Override
    protected ModelConverter<MsgTemplateDO, MsgTemplate> getModelConverter() {
        return msgTemplateConverter;
    }

    @Override
    protected BaseDAO<MsgTemplateDO, MsgTemplateDBQuery> getDAO() {
        return msgTemplateDAO;
    }

    @Override
    protected QueryConditionConverter<MsgTemplateQuery, MsgTemplateDBQuery> getConditionConverter() {
        return msgTemplateQueryConverter;
    }
}
