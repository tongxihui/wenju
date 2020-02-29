package com.kddyzn.wenju.controller;

import com.kddyzn.wenju.constant.AppConstant;
import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.util.CumtJwUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(AppConstant.API_MAP + "/test")
public class TestController {

    @Resource
    private CumtJwUtil cumtJwUtil;

    @PostMapping("/realName")
    public HttpResult getRealName(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password) {

        String name = cumtJwUtil.getRealName(userId, password);
        return new HttpResult(name);
    }
}
