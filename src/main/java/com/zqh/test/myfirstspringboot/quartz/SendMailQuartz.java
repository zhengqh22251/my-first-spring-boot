package com.zqh.test.myfirstspringboot.quartz;

import com.mysql.cj.util.TimeUtil;
import com.zqh.test.myfirstspringboot.mail.SendJunkMailService;
import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/13 19:40
 **/
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {
    //日志
    private static final Logger logger =
            LogManager.getLogger(SendMailQuartz.class);

    @Resource
    private SendJunkMailService sendJunkMailService;

    @Resource
    private AyUserService ayUserService;

    //每5s 执行一次
    @Scheduled(cron = "*/5 * *  * * *")
    public void reportCurrentByCorn(){
       //logger.info("定时器运行了！");
       List<AyUser> list = ayUserService.findAll();
       if(list == null ){return;}
       sendJunkMailService.sendJunkMail(list);
       logger.info("定时任务发送邮件提醒成功！！！");
    }

}
