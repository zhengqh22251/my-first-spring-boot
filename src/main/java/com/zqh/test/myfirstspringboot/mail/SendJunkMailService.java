package com.zqh.test.myfirstspringboot.mail;

import com.zqh.test.myfirstspringboot.model.AyUser;

import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/13 20:42
 **/
public interface SendJunkMailService {
    boolean sendJunkMail(List<AyUser> ayUser);
}
