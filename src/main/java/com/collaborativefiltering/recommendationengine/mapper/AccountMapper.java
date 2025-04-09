package com.collaborativefiltering.recommendationengine.mapper;

import com.collaborativefiltering.recommendationengine.entity.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper//此注解配合xml
public interface AccountMapper {

    @Select("select * from account")//此方法可不配xml
    public List<Account>  queryAccountList();
}
