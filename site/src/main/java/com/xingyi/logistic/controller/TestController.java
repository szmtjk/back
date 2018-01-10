package com.xingyi.logistic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jadic on 2017/6/7.
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping("/hi")
    public String testHi() {
        return "hi, i'm ok 2 2";
    }

}
