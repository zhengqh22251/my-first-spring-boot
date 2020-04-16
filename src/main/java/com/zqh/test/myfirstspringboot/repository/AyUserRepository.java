package com.zqh.test.myfirstspringboot.repository;

import com.zqh.test.myfirstspringboot.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/9 16:05
 **/
public interface AyUserRepository  extends JpaRepository<AyUser,String> {
    // 自定义的方法
    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<String> ids);
}
