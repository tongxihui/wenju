package com.kddyzn.wenju.config;

import com.google.common.collect.Lists;
import com.kddyzn.wenju.filter.UTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@Component
public class RestFilterConfig {

    @Resource
    private UTokenFilter uTokenFilter;

    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(uTokenFilter);

        List<String> urlPatterns = Lists.newArrayList();
        urlPatterns.add("");

        registrationBean.setOrder(1);
        registrationBean.setEnabled(false);
        return registrationBean;
    }
}
