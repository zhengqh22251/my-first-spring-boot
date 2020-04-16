package com.zqh.test.myfirstspringboot.listener;

import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.security.AllPermission;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/11 23:44
 **/

@WebListener
public class AyUserListener implements ServletContextListener {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private AyUserService ayUserService;

    private static final String ALL_USER = "ALL_USER_LIST";

    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 查询所有用户
        List<AyUser> ayUserList = ayUserService.findAll();
        // 清除缓存
        redisTemplate.delete(ALL_USER);
        // 将用户数据放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER,ayUserList);
        // 查询测试
        List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER,0,-1);
        logger.info("redis缓存了："+queryUserList.size()+"人");

        logger.info("上下文创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("上下文销毁");
    }
}
