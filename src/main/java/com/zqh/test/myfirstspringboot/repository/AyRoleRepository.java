package com.zqh.test.myfirstspringboot.repository;

import com.zqh.test.myfirstspringboot.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:33
 **/
public interface AyRoleRepository extends JpaRepository<AyRole,String> {
}
