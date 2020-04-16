package com.zqh.test.myfirstspringboot.repository;

import com.zqh.test.myfirstspringboot.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:33
 **/
public interface AyMoodRepository extends JpaRepository<AyMood,String> {
}
