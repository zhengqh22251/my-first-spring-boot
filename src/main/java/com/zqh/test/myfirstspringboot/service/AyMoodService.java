package com.zqh.test.myfirstspringboot.service;

import com.zqh.test.myfirstspringboot.model.AyMood;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:34
 **/
public interface AyMoodService {
    AyMood save(AyMood ayMood);
    String asynSave(AyMood ayMood);
}
