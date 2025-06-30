package com.example.baseTemplate.config;

import com.example.baseTemplate.filter.JwtAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseAuthenticationConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> adminJwtAuthenticationFilter(JwtConfig jwtConfig) {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthenticationFilter(jwtConfig));
        registrationBean.addUrlPatterns("/**"); // 对相关接口进行JWT验证
        registrationBean.setName("jwtAuthenticationFilter");
        registrationBean.setOrder(1); // 设置过滤器执行顺序
        return registrationBean;
    }
}