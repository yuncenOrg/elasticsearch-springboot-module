package com.liuyuncen.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.**.mapper")
public class ESModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESModuleApplication.class, args);
    }

}
