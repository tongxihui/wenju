package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.dao.po.auto.UserSecretP0;
import com.kddyzn.wenju.service.AuthTokenService;
import com.kddyzn.wenju.service.SecretService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Resource
    private SecretService secretService;

    @Override
    public boolean checkUToken(String utoken) {

        //判空
        if (StringUtils.isEmpty(utoken) || StringUtils.isBlank(utoken)) {
            return false;
        }

        UserSecretP0 userSecret = secretService.getSecretByToken(utoken);

        //token表里不存在
        if (userSecret == null) {
            return false;
        }

        return true;
    }
}
