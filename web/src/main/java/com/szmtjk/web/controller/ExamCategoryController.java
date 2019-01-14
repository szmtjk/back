package com.szmtjk.web.controller;

import com.szmtjk.business.model.ExamCategory;
import com.szmtjk.business.model.ExamCategoryQuery;
import com.szmtjk.business.model.ExamDetailReport;
import com.szmtjk.business.model.ExamDetailReportQuery;
import com.szmtjk.business.service.ExamDetailReportService;
import com.szmtjk.web.controller.base.BaseCRUDController;
import com.xxx.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/examCategory")
public class ExamCategoryController extends BaseCRUDController<ExamCategory, ExamCategoryQuery> {

    private static final Logger LOG = LoggerFactory.getLogger(ExamCategoryController.class);

    @Autowired
    private ExamDetailReportService examDetailReportService;

    @RequestMapping(value = "getCategories", method =  RequestMethod.GET)
    public JsonRet<List<ExamCategory>> getCategories(Long examId){
        ExamCategoryQuery condition = new ExamCategoryQuery();
        condition.setExamId(examId);
        JsonRet<List<ExamCategory>> result = getBaseService().getList(condition);

        if(result.isSuccess()) {
            List<ExamCategory> categories = result.getData();
            LOG.info("categories size" + categories.size());
            Iterator<ExamCategory> categoryIterator = categories.iterator();
            while(categoryIterator.hasNext()){
                ExamCategory category = categoryIterator.next();
                ExamDetailReportQuery query = new ExamDetailReportQuery();
                query.setCategoryId(category.getId());
                JsonRet<List<ExamDetailReport>> itemsResult = examDetailReportService.getList(query);
                if(itemsResult.isSuccess()) {
                    category.setItems(itemsResult.getData());
                }
            }
        }

        return result;
    }
}
