package com.collaborativefiltering.recommendationengine.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class RegisterController {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private String age;

    @RequestMapping("/register1")
    public String register() {
        System.out.println("name:" + this.name + "========age:" + this.age);
        return this.name;
    }
}
