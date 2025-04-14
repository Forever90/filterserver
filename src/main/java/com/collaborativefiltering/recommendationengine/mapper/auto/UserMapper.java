package com.collaborativefiltering.recommendationengine.mapper.auto;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.collaborativefiltering.recommendationengine.model.auto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里可以添加自定义的SQL查询方法
    // 由于使用了MyBatis-Plus，基本的CRUD操作已经由BaseMapper提供
}
