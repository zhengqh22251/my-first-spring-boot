package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.model.AyMood;
import com.zqh.test.myfirstspringboot.repository.AyMoodRepository;
import com.zqh.test.myfirstspringboot.service.AyMoodService;
import com.zqh.test.myfirstspringboot.service.mq.AyMoodProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:34
 **/
@Service
public class AyMoodServiceImpl implements AyMoodService {
    @Resource
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood ayMood) {
        return ayMoodRepository.save(ayMood);
    }

    private  static Destination destination =
            new ActiveMQQueue("ay.queue.asyn.save");
    @Resource
    private AyMoodProducer ayMoodProducer;
    @Override
    public String asynSave(AyMood ayMood) {
        // 往队列里面推送 说说实体信息
        ayMoodProducer.sendMessage(destination,ayMood);
        return "success";
    }
}
