package com.collaborativefiltering.recommendationengine.manage.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.collaborativefiltering.recommendationengine.manage.user.service.IAccountService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class LoginController {

    @Autowired
    @Qualifier("LoginServiceImpl")   //第一种方式注入数据
    private IAccountService LoginService;

    @Resource(name = "RegisterServiceImpl")     //第二种方式注入数据
    private IAccountService RegisterService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String name,@RequestParam("password") String pwd) {
        System.out.println("username:"+name+"=====password:"+pwd);
        if(LoginService.doAccount()){
            return "login success";
        }
        return "login failed";
    }

    //@RequestMapping("/register") //默认get方式
    @PostMapping("/register")
    public String register(@RequestParam("username") String name,@RequestParam("password") String pwd,@RequestParam("nickname") String nickname) {
        if(RegisterService.doAccount()){
            return "register success";
        }
        return "register failed";
    }

    @RequestMapping(value = "/testGet/{id}",method = RequestMethod.GET)
    //@GetMapping("/testGet")等效
    public Map testGet(@PathVariable("id") String id,@RequestParam("name") String name){
        Map<String, String> book = new HashMap<String, String>();
        book.put("id",id);
        book.put("name",name);
        return book;
    }

}
