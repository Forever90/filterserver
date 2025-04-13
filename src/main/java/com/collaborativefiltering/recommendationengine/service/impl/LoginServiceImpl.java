package com.collaborativefiltering.recommendationengine.service.impl;

import com.collaborativefiltering.recommendationengine.model.auto.Account;
import com.collaborativefiltering.recommendationengine.service.IAccountService;
import com.collaborativefiltering.recommendationengine.mapper.auto.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("LoginServiceImpl")
public class LoginServiceImpl implements IAccountService {

    @Value("${name}")
    private String name;

    @Autowired
    private AccountMapper accountMapper;

    public boolean doAccount(){
        List<Account> users = this.queryAccount();
        if(!users.isEmpty()){
            System.out.println("users[0]:" + users.get(0).toString());
            return true;
        }
        return false;
    }

    public List<Account> queryAccount(){
        return accountMapper.queryAccountList();
    }
}
