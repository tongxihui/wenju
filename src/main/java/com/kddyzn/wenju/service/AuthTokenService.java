package com.kddyzn.wenju.service;

import org.springframework.stereotype.Component;

@Component
public interface AuthTokenService {

    boolean checkUToken(String utoken);
}
