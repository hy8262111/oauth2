package com.ganwei.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;

/**
 * @Author: houyong
 * @Date: 2019/9/24 11:24
 * @describe
 */
@SpringBootApplication
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
    //AffirmativeBased
    //DefaultFilterInvocationSecurityMetadataSource
    //AbstractSecurityInterceptor
}