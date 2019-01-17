package com.szmtjk.web.controller;

import com.szmtjk.authentication.util.UserSessionUtil;
import com.szmtjk.business.bean.wechat.AppType;
import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamQuery;
import com.szmtjk.business.model.User;
import com.szmtjk.business.service.WeChatBindService;
import com.szmtjk.web.controller.base.BaseCRUDController;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController extends BaseCRUDController<Exam, ExamQuery> {

    @Override
    @RequestMapping(value = "/getList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonRet<Object> getList(ExamQuery examQuery) {
        User user = UserSessionUtil.getCurrentUser();
        if (user == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_BIND_USER_NOT_EXIST);
        }

        examQuery.setUserId(user.getId());
        return super.getList(examQuery);
    }
}
