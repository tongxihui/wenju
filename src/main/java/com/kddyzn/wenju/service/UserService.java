package com.kddyzn.wenju.service;

import com.kddyzn.wenju.dao.po.auto.UserP0;
import com.kddyzn.wenju.model.params.UpdateUserParam;

import java.util.List;

public interface UserService {

    /**
     * 用户登录
     * @param userId
     * @param password
     * @return
     */
    String login(String userId, String password);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    UserP0 getUserById(String userId);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    UserP0 getUserByPhone(String phone);

    /**
     * 更新用户信息
     * @param userId
     * @return
     */
    void updateUser(UpdateUserParam param);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserP0> getAll();
}
