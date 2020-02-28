package com.kddyzn.wenju.service;

import com.kddyzn.wenju.model.UserSecret;
import org.springframework.stereotype.Service;

@Service
public interface UserSecretService {

    UserSecret selectUserSecret(String userId);

    void updateById(UserSecret userSecret);

    UserSecret selectUserSecretByToken(String utoken);

    void deleteById(String userId);
}
