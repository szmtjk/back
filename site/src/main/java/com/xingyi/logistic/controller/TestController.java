package com.xingyi.logistic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jadic on 2017/6/7.
 */
@RestController
public class TestController {

    @RequestMapping("/hi")
    public String testHi() {
        return "hi, i'm ok";
    }

}
