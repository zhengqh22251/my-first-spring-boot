package com.zqh.test.myfirstspringboot.service.mq;

import com.zqh.test.myfirstspringboot.model.AyMood;
import com.zqh.test.myfirstspringboot.service.AyMoodService;
import com.zqh.test.myfirstspringboot.service.impl.AyMoodServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:49
 **/
@Component
public class AyMoodConsumer {
   private static final Logger logger = LogManager.getLogger(AyMoodConsumer.class);

   @JmsListener(destination = "ay.queue")
   public void receiveQueue(String text){
       logger.info("用户发表说说--->【"+text+"】成功！");

   }

    @Resource
    private AyMoodService ayMoodService;

    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyMood ayMood){
        ayMoodService.save(ayMood);
        logger.info("【异步】发表说说成功！");
    }
}
