package com.kddyzn.wenju.config;

import com.kddyzn.wenju.constant.AppConstant;
import com.kddyzn.wenju.dao.po.auto.UserSecretP0;
import com.kddyzn.wenju.service.SecretService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    SecretService secretService;

    /**
     * 拦截白名单
     */
    private String[] whiteList = {
            "/api/user/login",
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        String utoken = request.getHeader(AppConstant.UTOKEN);
        String method = request.getMethod();
        if (!method.equals("OPTIONS")) {

            // 白名单内返回true
            for (String item : whiteList) {
                if (item.equals(url)) {
                    return true;
                }
            }

            UserSecretP0 userSecret = secretService.getSecretByToken(utoken);

            if (userSecret == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
