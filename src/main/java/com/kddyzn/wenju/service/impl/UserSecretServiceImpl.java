package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.dao.mapper.redis.UserSecretMapper;
import com.kddyzn.wenju.model.UserSecret;
import com.kddyzn.wenju.service.UserSecretService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "userSecrets")
public class UserSecretServiceImpl implements UserSecretService {

    @Resource
    private UserSecretMapper userSecretMapper;

    @Override
    @Cacheable(key = "#p0")
    public UserSecret selectUserSecret(String userId) {
        return userSecretMapper.findById(userId);
    }

    @Override
    @CachePut(key = "#p0")
    public void updateById(UserSecret userSecret) {
        userSecretMapper.updateById(userSecret);
    }

    @Override
    @CacheEvict(key = "#p0", allEntries = true)
    public void deleteById(String userId){
        userSecretMapper.deleteById(userId);
    }
}
