package com.zqh.test.myfirstspringboot.service;

import com.zqh.test.myfirstspringboot.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Author：zhengqh
 * @date 2020/4/9 16:09
 **/
public interface AyUserService {
    AyUser findById(String id);
    // 同步查询
    List<AyUser> findAll();
    // 异步查询
    Future<List<AyUser>> findAsynAll();
    // 保存  更新
    AyUser save(AyUser ayUser);
    void delete(String id);
    //分页
    Page<AyUser> findAll(Pageable pageable);
    //自定义方法
    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<String> ids);

    AyUser findByNameAndPassword(String name,String password);

    // 重试
    AyUser findByNameAndPasswordRetry(String name,String password) throws Exception;

}
