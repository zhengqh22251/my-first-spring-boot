package com.zqh.test.myfirstspringboot.service.mq;

import com.zqh.test.myfirstspringboot.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:45
 **/

@Service
public class AyMoodProducer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
    public void sendMessage(Destination destination,final AyMood ayMood){
        jmsMessagingTemplate.convertAndSend(destination,ayMood);
    }
}
