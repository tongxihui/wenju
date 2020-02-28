package com.kddyzn.wenju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.kddyzn.wenju.dao.mapper")
public class WenjuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenjuApplication.class, args);
    }

}
