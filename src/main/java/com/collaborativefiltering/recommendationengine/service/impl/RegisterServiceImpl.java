package com.collaborativefiltering.recommendationengine.service.impl;

import com.collaborativefiltering.recommendationengine.service.IAccountService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service("RegisterServiceImpl")
@ConfigurationProperties(prefix = "person")
public class RegisterServiceImpl implements IAccountService {
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public boolean doAccount(){
        System.out.println(sex);
        return false;
    }
}
