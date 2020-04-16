package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.model.AyUserAttachmentRel;
import com.zqh.test.myfirstspringboot.repository.AyUserAttachmentRefRepository;
import com.zqh.test.myfirstspringboot.service.AyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：zhengqh
 * @date 2020/4/15 11:05
 **/
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {
    @Resource
    private AyUserAttachmentRefRepository ayUserAttachmentRelRepository;
    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
