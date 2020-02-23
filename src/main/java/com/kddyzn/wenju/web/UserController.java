package com.kddyzn.wenju.web;

import com.kddyzn.wenju.dao.po.auto.UserP0;
import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.model.UserV0;
import com.kddyzn.wenju.model.params.UpdateUserParam;
import com.kddyzn.wenju.model.params.UserLoginParam;
import com.kddyzn.wenju.service.UserService;
import com.kddyzn.wenju.service.util.CumtJwUtil;
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

    /**
     * 用户登录
     *
     * @param param
     * @return
     */
    @PostMapping("/login")
    public HttpResult userLogin(
            @RequestBody @Valid UserLoginParam param) {
        System.out.println(new CumtJwUtil().getLoginToken("04171180", "a821589498wmr"));
        return new HttpResult(0, "success", null);
    }

    /**
     * 根据id获取用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/id/{userId}")
    public HttpResult getUserById(@PathVariable String userId) {
        if (userId == null || userId.length() == 0) {
            return null;
        }
        UserP0 userP0 = userService.getUserById(userId);
        return new HttpResult(UserV0.toUserVo(userP0));
    }

    @PutMapping("")
    public HttpResult updateUser(
            @RequestBody @Valid UpdateUserParam param) {
        return new HttpResult();
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("")
    public HttpResult getAllUser() {
        List<UserP0> p0List = userService.getAll();
        List<UserV0> v0List = new ArrayList<>();
        p0List.forEach((userP0 -> v0List.add(UserV0.toUserVo(userP0))));
        return new HttpResult(v0List);
    }
}
