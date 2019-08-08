package com.xy.shoppro.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SYQ
 * Created on 2019\8\6 0006 19:33
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
//@Component
//@ControllerAdvice
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源放行
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }

}