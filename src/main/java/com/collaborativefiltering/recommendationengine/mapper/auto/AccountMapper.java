package com.collaborativefiltering.recommendationengine.mapper.auto;

import com.collaborativefiltering.recommendationengine.model.auto.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper//此注解配合xml
@Mapper
public interface AccountMapper {

    @Select("select * from account")//此方法可不配xml
    public List<Account>  queryAccountList();
}
