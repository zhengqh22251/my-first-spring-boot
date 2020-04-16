package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.model.AyUserRoleRef;
import com.zqh.test.myfirstspringboot.repository.AyUserRoleRelRepository;
import com.zqh.test.myfirstspringboot.service.AyUserRoleRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/15 17:45
 **/
@Service
public class AyUserRoleRefServiceImpl implements AyUserRoleRefService {
    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;
    @Override
    public List<AyUserRoleRef> findByUserId(String userid) {
        return ayUserRoleRelRepository.findByUserId(userid);
    }
}
