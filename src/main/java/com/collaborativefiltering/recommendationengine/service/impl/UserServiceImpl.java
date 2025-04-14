package com.collaborativefiltering.recommendationengine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.collaborativefiltering.recommendationengine.mapper.auto.UserMapper;
import com.collaborativefiltering.recommendationengine.model.auto.User;
import com.collaborativefiltering.recommendationengine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        // 检查用户名是否已存在
        if (findByUsername(user.getUsername()) != null) {
            return false;
        }

        // 密码加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        
        // 设置创建时间和更新时间
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setCreateTime(now);
        user.setUpdateTime(now);
        
        // 设置默认状态为启用
        user.setStatus(1);
        
        return save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper);
    }
}
