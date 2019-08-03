package com.xy.dubboshoppro.background;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xy.dubboshoppro.entity.TProductBasic;
import com.xy.dubboshoppro.service.IProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:43
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Reference
    private IProductService productService;

    @RequestMapping("hello")
    public String hello(){
       String s=productService.hello("SpringBootDubbo,MyWorld!");
       return s;
    }

    @RequestMapping("getOneTest/{id}")
    public TProductBasic getProductById(@PathVariable Long id){

        return productService.getProductById(id);
    }
}
