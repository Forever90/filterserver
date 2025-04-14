package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO )
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "role")
    private String role;

    @TableField(value = "email")
    private String email;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "status")
    private Integer status; // 0-禁用 1-启用

    @TableField(value = "createTime")
    private String createTime;

    @TableField(value = "updateTime")
    private String updateTime;
}
