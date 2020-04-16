package com.zqh.test.myfirstspringboot.service;

import com.zqh.test.myfirstspringboot.model.AyUserRoleRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/15 17:42
 **/
public interface AyUserRoleRefService {

    List<AyUserRoleRef> findByUserId(String userid);

}
