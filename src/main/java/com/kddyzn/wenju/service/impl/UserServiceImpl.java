package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.dao.mapper.auto.UserMapper;
import com.kddyzn.wenju.dao.po.auto.UserP0;
import com.kddyzn.wenju.dao.po.auto.UserP0Example;
import com.kddyzn.wenju.model.params.UpdateUserParam;
import com.kddyzn.wenju.service.UserService;
import com.kddyzn.wenju.util.CumtJwUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private CumtJwUtil cumtJwUtil;

    @Override
    public boolean login(String userId, String password) {
        String token = cumtJwUtil.getLoginToken(userId, password);
        if (token == null || token.length() == 0) {
            return false;
        }
        UserP0 userP0 = new UserP0();
        userP0.setUserId(userId);
        userP0.setToken(token);
        userMapper.insertSelective(userP0);
        return true;
    }

    @Override
    public UserP0 getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserP0 getUserByPhone(String phone) {
        UserP0Example example = new UserP0Example();
        example.createCriteria().andPhoneEqualTo(phone);
        List<UserP0> p0List = userMapper.selectByExample(example);
        if (p0List.size() > 0) {
            return p0List.get(0);
        }
        return null;
    }

    @Override
    public void updateUser(UpdateUserParam param) {
        UserP0 userP0 = new UserP0();
        userP0.setUserId(param.getUserId());
        userP0.setPhone(param.getPhone());
        userP0.setNickName(param.getNickName());
        userP0.setEmail(param.getEmail());
        userP0.setQq(param.getQq());
        userP0.setWx(param.getWx());
        userMapper.updateByPrimaryKeySelective(userP0);
    }

    @Override
    public List<UserP0> getAll() {
        UserP0Example example = new UserP0Example();
        return userMapper.selectByExample(example);
    }
}
