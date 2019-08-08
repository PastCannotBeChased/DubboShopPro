package com.xy.shoppro;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.xy.shoppro.mapper")
public class ShopproProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopproProductServiceApplication.class, args);
    }

}
