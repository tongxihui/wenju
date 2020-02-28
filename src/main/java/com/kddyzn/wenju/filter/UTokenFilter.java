package com.kddyzn.wenju.filter;

import com.kddyzn.wenju.constant.AppConstant;
import com.kddyzn.wenju.service.AuthTokenService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UTokenFilter implements Filter {

    @Resource
    private AuthTokenService authTokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String utoken = httpServletRequest.getHeader(AppConstant.UTOKEN);
        boolean passed = authTokenService.checkUToken(utoken);
        if (!passed) {
            System.out.println("验证失败");
        }
    }

    @Override
    public void destroy() {

    }
}
