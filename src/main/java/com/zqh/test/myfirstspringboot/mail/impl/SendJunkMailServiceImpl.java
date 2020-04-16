package com.zqh.test.myfirstspringboot.mail.impl;

import com.zqh.test.myfirstspringboot.mail.SendJunkMailService;
import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.service.AyUserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/13 20:43
 **/

@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {
    @Autowired
    JavaMailSender mailSender;
    @Resource
    private AyUserService ayUserService;
    @Value("${spring.mail.username}")
    private String from;

    public static final Logger logger=
            LogManager.getLogger(SendJunkMailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<AyUser> ayUser) {
        if(ayUser.size()<=0 || ayUser == null){
            return Boolean.FALSE;
        }
        // 这里测试  没有用到ayUser
        /*for (AyUser user : ayUser) {*/
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            try {
                // 邮件发送方
                message.setFrom(from);
                // 主题
                message.setSubject("余笑笑下班了！！！");
                //邮件接收方
                 message.setTo("1315654837@qq.com");
                 //message.setTo("1150173792@qq.com");
                // 邮件内容
                message.setText("都几点了,还tm不下班！");

                logger.info("邮件提醒成功");

                //发送邮件 暂时不发送邮件
                 //this.mailSender.send(mimeMessage);

            } catch (MessagingException e) {
                logger.info("邮件发送失败"+e);
                return  Boolean.FALSE;
            }

        /*}*/

        return  Boolean.TRUE;
    }
}
