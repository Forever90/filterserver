package com.collaborativefiltering.recommendationengine.controller.admin;

import com.collaborativefiltering.recommendationengine.model.auto.User;
import com.collaborativefiltering.recommendationengine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        boolean success = userService.register(user);
        result.put("success", success);
        if (!success) {
            result.put("message", "用户名已存在");
        }
        return result;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.login(username, password);
        if (user != null) {
            result.put("success", true);
            result.put("user", user);
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }

    @GetMapping("/info/{username}")
    public Map<String, Object> getUserInfo(@PathVariable String username) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.findByUsername(username);
        if (user != null) {
            result.put("success", true);
            result.put("user", user);
        } else {
            result.put("success", false);
            result.put("message", "用户不存在");
        }
        return result;
    }
}
