package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.model.UserSecret;
import com.kddyzn.wenju.service.AuthTokenService;
import com.kddyzn.wenju.service.UserSecretService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Resource private UserSecretService userSecretService;

    @Override
    public boolean checkUToken(String utoken) {

        //判空
        if (StringUtils.isEmpty(utoken) || StringUtils.isBlank(utoken)) {
            return false;
        }

        UserSecret userSecret = userSecretService.selectUserSecretByToken(utoken);

        //token表里不存在
        if (userSecret == null) {
            return false;
        }

        return true;
    }
}
