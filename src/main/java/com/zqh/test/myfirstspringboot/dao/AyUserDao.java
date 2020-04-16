package com.zqh.test.myfirstspringboot.dao;

import com.zqh.test.myfirstspringboot.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：zhengqh
 * @date 2020/4/14 12:40
 **/
@Mapper
public interface AyUserDao {
    AyUser findByNameAndPassword(@Param("name") String name,
                                 @Param("password") String password);
}
