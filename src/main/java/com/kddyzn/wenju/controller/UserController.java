package com.kddyzn.wenju.controller;

import com.kddyzn.wenju.dao.po.auto.UserP0;
import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.model.UserV0;
import com.kddyzn.wenju.model.params.UpdateUserParam;
import com.kddyzn.wenju.model.params.UserLoginParam;
import com.kddyzn.wenju.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @ApiOperation(value = "用户登录", notes = "统一认证登录")
    @ApiImplicitParam(required = true, dataType = "String")
    @PostMapping("/login")
    public HttpResult userLogin(
            @RequestBody @Valid UserLoginParam param) {
        boolean result = userService.login(param.getUserId(), param.getPassword());
        return new HttpResult(result ? "登录成功" : "登录失败");
    }

    @ApiOperation(value = "查询用户信息", notes = "根据学号/工号查询用户信息")
    @ApiImplicitParam(name = "userId", value = "学号/工号", required = false, dataType = "String")
    @GetMapping("/{userId}")
    public HttpResult getUserById(@PathVariable String userId) {
        //获取全部
        if (userId == null) {
            List<UserP0> p0List = userService.getAll();
            List<UserV0> v0List = new ArrayList<>();
            p0List.forEach((userP0 -> v0List.add(UserV0.toUserVo(userP0))));
            return new HttpResult(v0List);
        }

        //获取单个
        if (userId.length() == 0) {
            return null;
        }
        UserP0 userP0 = userService.getUserById(userId);
        return new HttpResult(UserV0.toUserVo(userP0));
    }

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam()
    @PutMapping("")
    public HttpResult updateUser(
            @RequestBody @Valid UpdateUserParam param) {
        if (getUserById(param.getUserId()) == null) {
            //不存在
            return null;
        }
        userService.updateUser(param);
        return new HttpResult("更新成功");
    }
}
