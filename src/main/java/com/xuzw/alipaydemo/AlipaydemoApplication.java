package com.xuzw.alipaydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.xuzw"})
@MapperScan("com.xuzw")
public class AlipaydemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AlipaydemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AlipaydemoApplication.class, args);
    }
}
