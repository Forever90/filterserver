package com.collaborativefiltering.recommendationengine.manage.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.kylin.mapper") //扫描mapper包，不配xml 和 @mapper注解
public class KylinApplication {
    public static void main(String[] args) {
        SpringApplication.run(KylinApplication.class);//特别注意不是写SpringBootApplication 写自己的类！！！！！！！！ 被蠢哭了
    }
}
