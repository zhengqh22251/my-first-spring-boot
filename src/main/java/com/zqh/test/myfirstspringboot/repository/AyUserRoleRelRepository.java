package com.zqh.test.myfirstspringboot.repository;

import com.zqh.test.myfirstspringboot.model.AyMood;
import com.zqh.test.myfirstspringboot.model.AyUserRoleRef;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:33
 **/
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRef,String> {
    List<AyUserRoleRef> findByUserId(@Param("userId")String userid);

}
