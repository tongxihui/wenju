package com.kddyzn.wenju.service;

import com.kddyzn.wenju.dao.po.auto.UserSecretP0;
import com.kddyzn.wenju.model.params.CreateSecretParam;

public interface SecretService {

    /**
     * 创建新令牌
     * @param param
     * @return
     */
    Integer insertSecret(CreateSecretParam param);

    /**
     * 根据Token获取令牌
     * @param utoken
     * @return
     */
    UserSecretP0 getSecretByToken(String utoken);

    /**
     * 根据id获取令牌
     * @param userId
     * @return
     */
    UserSecretP0 getSecretById(String userId);

    /**
     * 删除令牌
     * @param userId
     */
    void deleteSecret(String userId);
}
