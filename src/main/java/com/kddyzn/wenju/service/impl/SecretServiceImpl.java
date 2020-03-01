package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.constant.AppConstant;
import com.kddyzn.wenju.dao.mapper.auto.SecretMapper;
import com.kddyzn.wenju.dao.po.auto.UserSecretP0;
import com.kddyzn.wenju.dao.po.auto.UserSecretP0Example;
import com.kddyzn.wenju.model.params.CreateSecretParam;
import com.kddyzn.wenju.service.SecretService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecretServiceImpl implements SecretService {

    @Resource
    SecretMapper secretMapper;

    @Override
    public Integer insertSecret(CreateSecretParam param) {
        UserSecretP0 userSecretP0 = new UserSecretP0();
        userSecretP0.setUserId(param.getUserId());
        userSecretP0.setUtoken(param.getUtoken());
        userSecretP0.setCreateTime(System.currentTimeMillis());
        if (secretMapper.selectByPrimaryKey(param.getUserId()) != null) {
            return secretMapper.updateByPrimaryKey(userSecretP0);
        } else {
            return secretMapper.insertSelective(userSecretP0);
        }
    }

    @Override
    public UserSecretP0 getSecretByToken(String utoken) {
        UserSecretP0Example example = new UserSecretP0Example();
        example.createCriteria().andUtokenLike(utoken);
        List<UserSecretP0> secretList = secretMapper.selectByExample(example);
        if (secretList == null || secretList.size() == 0) {
            return null;
        }
        UserSecretP0 userSecretP0 = secretList.get(0);
        if (userSecretP0.getCreateTime() + AppConstant.UTOKEN_ALIVE_TIME < System.currentTimeMillis()) {
            return null;
        }
        return userSecretP0;
    }

    @Override
    public UserSecretP0 getSecretById(String userId) {
        UserSecretP0 userSecretP0 = secretMapper.selectByPrimaryKey(userId);
        if (userSecretP0.getCreateTime() + AppConstant.UTOKEN_ALIVE_TIME < System.currentTimeMillis()) {
            return null;
        }
        return userSecretP0;
    }

    @Override
    public void deleteSecret(String userId) {
        secretMapper.deleteByPrimaryKey(userId);
    }
}
