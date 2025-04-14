package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.collaborativefiltering.recommendationengine.model.auto.User;

public interface IUserService extends IService<User> {
    /**
     * 用户注册
     * @param user 用户信息
     * @return 注册结果
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    User login(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);
}
