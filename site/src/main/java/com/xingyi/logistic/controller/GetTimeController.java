package com.xingyi.logistic.controller;

import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("time")
public class GetTimeController extends BaseController{

    @RequestMapping(value = "/getTime", method = RequestMethod.GET)
    @ResponseBody
    public JsonRet<Object> upLoad() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        Map<String, Object> params = new HashMap<>();
        params.put("time",time);
        return JsonRet.getSuccessRet(params);
    }

}
