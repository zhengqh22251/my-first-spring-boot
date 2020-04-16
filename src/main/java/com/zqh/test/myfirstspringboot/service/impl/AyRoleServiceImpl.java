package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.model.AyRole;
import com.zqh.test.myfirstspringboot.repository.AyRoleRepository;
import com.zqh.test.myfirstspringboot.service.AyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：zhengqh
 * @date 2020/4/15 17:43
 **/

@Service
public class AyRoleServiceImpl implements AyRoleService {

    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id) {
        return ayRoleRepository.findById(id).get();
    }
}
