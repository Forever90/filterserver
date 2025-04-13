package com.collaborativefiltering.recommendationengine;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication 
//@MapperScan("com.collaborativefiltering.recommendationengine.mapper") //扫描mapper包，不配xml 和 @mapper注解
//@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*"})//固定的
//@ComponentScan("com.gitee.sunchenbin.mybatis.actable.manager.*")//固定的
public class KylinApplication {
    public static void main(String[] args) {
        SpringApplication.run(KylinApplication.class);//特别注意不是写SpringBootApplication 写自己的类！！！！！！！！ 被蠢哭了
    }
}
